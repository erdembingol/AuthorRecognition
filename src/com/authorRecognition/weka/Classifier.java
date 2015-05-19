package com.authorRecognition.weka;

import com.authorRecognition.ui.swing.MessageBox;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import weka.classifiers.AbstractClassifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.BayesNet;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.classifiers.functions.SimpleLogistic;
import weka.classifiers.meta.RandomCommittee;
import weka.classifiers.trees.LMT;
import weka.core.Instances;

public class Classifier {
    
    public static String classify(int classSize, String filename, String method){
        StringBuilder result = new StringBuilder();
        
        //Dosyadan verileri oku ve sınıflandırma yap
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filename));

            Instances train = new Instances(br);
            train.setClassIndex(train.numAttributes()-1);
            br.close();
            
            AbstractClassifier classifier = null;      
            
            switch (method) {
                case "Bayes Network":
                    classifier = new BayesNet();
                    break;
                case "Naive Bayes":
                    classifier = new NaiveBayes();
                    break;
                case "Support Vector Machine":
                    classifier = new SMO();
                    break;
                case "Simple Logistic":
                    classifier = new SimpleLogistic();
                    break;
                case "LMT":
                    classifier = new LMT();
                    break;
                default:
                    classifier = new RandomCommittee();
                    break;
            }
            classifier.buildClassifier(train);
            
            Evaluation eval = new Evaluation(train);
            eval.crossValidateModel(classifier, train, classSize, new Random(1));
            
            printResult(eval, classSize, train, result);
        } catch (Exception ex) {
            MessageBox.errorMessage("", "Classification not done!!!");
        }
        
        return result.toString();
    }  
    
    public static String[] find(String trainFile, String testFile, String method) throws IOException, Exception{
        Instances train = new Instances(new BufferedReader(new FileReader(trainFile)));
        train.setClassIndex(train.numAttributes() - 1);
        Instances test = new Instances(new BufferedReader(new FileReader(testFile)));
        test.setClassIndex(train.numAttributes() - 1);
        
        String[] result = new String[2];
        
//        NaiveBayes naivebayes = new NaiveBayes();
//        naivebayes.buildClassifier(train);
//        double pred = naivebayes.classifyInstance(test.instance(0));
//        double[] dist = naivebayes.distributionForInstance(test.instance(0));
        
        
        AbstractClassifier classifier = null;                
        switch (method) {
            case "Bayes Network":
                classifier = new BayesNet();
                break;
            case "Naive Bayes":
                classifier = new NaiveBayes();
                break;
            case "Support Vector Machine":
                classifier = new SMO();
                break;
            case "Simple Logistic":
                classifier = new SimpleLogistic();
                break;
            case "LMT":
                classifier = new LMT();
                break;
            default:
                classifier = new RandomCommittee();
                break;
        }
        classifier.buildClassifier(train);
        double pred = classifier.classifyInstance(test.instance(0));
        double[] dist = classifier.distributionForInstance(test.instance(0));
        
        
        System.out.print((1) + " - ");
        System.out.print(test.instance(0).toString(test.classIndex()) + " - ");
        System.out.print(test.classAttribute().value((int) pred) + " - ");
        result[0] = String.valueOf(test.classAttribute().value((int) pred));
        result[1] = String.valueOf(0.0);
        
        for (int i = 0; i < dist.length; i++) {
            if(i==(int)pred){
                result[1] = String.valueOf(dist[i]);
            }
        }
        result[1] = "%" + String.valueOf((int)(Double.valueOf(result[1]) * 100));

        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]);
        }
        
        return result;
    }  
    
    private static void printResult(Evaluation eval, int classSize,Instances train, StringBuilder result) throws Exception{
        result.append("Total Number of Instances            ").append((int)eval.numInstances()).append("\n\n");
        
        result.append("Correctly Classified Instances       ").append((int)eval.correct()).append("     ").append("%").append(eval.correct()/eval.numInstances()*100).append("\n");
        result.append("Incorrectly Classified Instances     ").append((int)eval.incorrect()).append("     ").append("%").append(eval.incorrect()/eval.numInstances()*100).append("\n\n");
        
        result.append("\n").append(eval.toMatrixString());
        
        String value = "";
        result.append("\n\n===Accurancy Matrix===");
        result.append("\n\nTP Rate   FP Rate   FMeasure   Precision   Recall   MCC     ROC    PRC    Class\n");
        result.append("----------------------------------------------------------------");
        result.append("--------------------------------------------------------------\n");
        for (int i = 0; i < classSize; i++) {
            value = String.valueOf(eval.truePositiveRate(i));
            value += "000";
            result.append(value.substring(0, 5)).append("       ");
            
            value = String.valueOf(eval.falsePositiveRate(i));
            value += "000";
            result.append(value.substring(0, 5)).append("       ");
            
            value = String.valueOf(eval.fMeasure(i));
            value += "000";
            result.append(value.substring(0, 5)).append("           ");
            
            value = String.valueOf(eval.precision(i));
            value += "000";
            result.append(value.substring(0, 5)).append("          ");
            
            value = String.valueOf(eval.recall(i));
            value += "000";
            result.append(value.substring(0, 5)).append("     ");
            
            value = String.valueOf(eval.matthewsCorrelationCoefficient(i));
            value += "000";
            result.append(value.substring(0, 5)).append("   ");
            
            value = String.valueOf(eval.areaUnderROC(i));
            value += "000";
            result.append(value.substring(0, 5)).append("   ");
            
            value = String.valueOf(eval.areaUnderPRC(i));
            value += "000";
            result.append(value.substring(0, 5)).append("   ");

            result.append(train.classAttribute().value(i)).append("\n");
        }
        
        result.append("----------------------------------------------------------------");
        result.append("--------------------------------------------------------------\n");
        
        value = String.valueOf(eval.weightedTruePositiveRate());
        value += "000";
        result.append(value.substring(0, 5)).append("       ");
        value = String.valueOf(eval.weightedFalsePositiveRate());
        value += "000";
        result.append(value.substring(0, 5)).append("       ");
        value = String.valueOf(eval.weightedFMeasure());
        value += "000";
        result.append(value.substring(0, 5)).append("           ");
        value = String.valueOf(eval.weightedPrecision());
        value += "000";
        result.append(value.substring(0, 5)).append("          ");
        value = String.valueOf(eval.weightedRecall());
        value += "000";
        result.append(value.substring(0, 5)).append("     ");
        value = String.valueOf(eval.weightedMatthewsCorrelation());
        value += "000";
        result.append(value.substring(0, 5)).append("   ");
        value = String.valueOf(eval.weightedAreaUnderROC());
        value += "000";
        result.append(value.substring(0, 5)).append("   ");
        value = String.valueOf(eval.weightedAreaUnderPRC());
        value += "000";
        result.append(value.substring(0, 5)).append("   ");
        
        result.append("Weighted Average\n\n\n");
    }
}
