package com.authorRecognition.zemberek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.zemberek.yapi.Kelime;
import net.zemberek.yapi.ek.Ek;

public class ArticleOperation {

    private Article article;
    private ZemberekConnection zb = new ZemberekConnection();
    private final String[] abreveationList = {"PROF", "ARŞ", "WWW", "GOV", "EDU", "COM", "NET", "TR", "GÖR", "VB", "VS", 
                                        "ORG", "OR", "MAH", "CAD", "SK", "NO", "DR", "HZ", "BK", "APT", "A", "P", "M"};

    /**
     * ****************************** SENTENCES ******************************
     */
    private List<String> sentences;
    private List<String> questionSentences = new ArrayList<String>();
    private List<String> exclamationSentences = new ArrayList<String>();
    private List<String> inverseSentences = new ArrayList<String>();
    private List<String> nounSentences = new ArrayList<String>();
    private List<String> positiveSentences = new ArrayList<String>();
    private List<String> negatifSentences = new ArrayList<String>();
    private List<String> regularSentences = new ArrayList<String>();
    private List<String> verbSentences = new ArrayList<String>();
    private List<String> simpleSentences = new ArrayList<String>();
    private List<String> unifiedSentences = new ArrayList<String>();

    /**
     * ******************************** WORDS ********************************
     */   
    private List<String> words;
    private Set<String> differentWords;
    private List<String> pronouns = new ArrayList<String>();
    private List<String> questionWords = new ArrayList<String>();
    private List<String> prepositions = new ArrayList<String>();
    private List<String> connectives = new ArrayList<String>();
    private List<String> properNouns = new ArrayList<String>();
    private List<String> nums = new ArrayList<String>();     
    private List<String> verbs = new ArrayList<String>();
    private List<String> nouns = new ArrayList<String>();
    private List<String> adjectives = new ArrayList<String>();
    private List<String> errorWords = new ArrayList<String>();
    private List<String> abbreviations = new ArrayList<String>();
    private List<String> exclamations = new ArrayList<String>();
    private List<String> amputations = new ArrayList<String>();
    private List<String> times = new ArrayList<String>();

    /**
     * ******************************** MARKS ********************************
     */   
    private int pointSize = 0;
    private int commaSize = 0;
    private int colonSize = 0;
    private int semicolonSize = 0;
    private int hypenSize = 0;
    private int quotationSize = 0;
    private int ellipsisPointSize = 0;
    private int exlamationSize = 0;
    private int paranthesisSize = 0;
    private int questionMarkSize = 0;
    
    /**
     * ***********************************************************************
     */ 
    
    private int capitalLetterSize = 0;       
    private int numberSize = 0;
    
    /**
     * ***********************************************************************
     */ 
       
    private int twoTimesWordSize = 0;
    private int threeTimesWordSize = 0;
    private int fourTimesWordSize = 0;
    private int fiveTimesWordSize = 0;
    private int sixTimesWordSize = 0;

    
    public List<String> getArticleProperties() {       
        List<String> map = new ArrayList<>();
        map.add("ExclamationSentences");
        map.add("InverseSentences");
//        map.add("NounSentences");
//        map.add("QuestionSentences");
        map.add("NegatifSentences");
//        map.add("PositiveSentences");
//        map.add("RegularSentences");
//        map.add("SimpleSentences");
//        map.add("UnifiedSentences");
//        map.add("VerbSentences");
        
        map.add("Connectives");
        map.add("Nums");
//        map.add("Prepositions");
        map.add("Pronouns");
//        map.add("ProperNouns");
        map.add("QuestionWords"); 
        map.add("Abbreviations");
//        map.add("Adjectives");
//        map.add("Amputations");
//        map.add("ErrorWords");
//        map.add("Exclamations");
//        map.add("Nouns");
        map.add("Times");
//        map.add("Verbs"); 
        
        map.add("ColonSize");
        map.add("CommaSize");
        map.add("EllipsisPointSize");
        map.add("HypenSize");
        map.add("PointSize");
        map.add("QuotationSize");
        map.add("SemicolonSize");
        map.add("ExlamationSize");
        map.add("ParanthesisSize");
        map.add("QuestionMarkSize");
        
        map.add("CapitalLetterSize");
//        map.add("NumberSize");
        
        map.add("AverageSentencesLength");
        map.add("AverageWordCountPerSentences");
        map.add("AverageWordLength");
        
        map.add("Dugasts");
        map.add("Guiard");           
//        map.add("Brunet");
//        map.add("Herdan");
//        map.add("Janenkov");
        map.add("Maas");
        map.add("Rubet");
        map.add("Sichel");
        
        map.add("TypeTokenRatio");
//        map.add("TwoTimesWords");
//        map.add("ThreeTimesWords");
//        map.add("FourTimesWords");
//        map.add("FiveTimesWords");
//        map.add("SixTimesWords");
        
        return map;
    }
    
    public List<String> getArticleValues() {        
        List<String> map = new ArrayList<>();
        map.add(String.valueOf(Math.floor(((double)this.exclamationSentences.size() / (double)this.getSentenceCount()) * 1000)));
        map.add(String.valueOf(Math.floor(((double)this.inverseSentences.size() / (double)this.getSentenceCount()) * 1000)));
//        map.add(String.valueOf(Math.floor(((double)this.nounSentences.size() / (double)this.getSentenceCount()) * 1000)));
//        map.add(String.valueOf(Math.floor(((double)this.questionSentences.size() / (double)this.getSentenceCount()) * 1000)));
        map.add(String.valueOf(Math.floor(((double)this.negatifSentences.size() / (double)this.getSentenceCount()) * 1000)));
//        map.add(String.valueOf(Math.floor(((double)this.positiveSentences.size() / (double)this.getSentenceCount()) * 1000)));
//        map.add(String.valueOf(Math.floor(((double)this.regularSentences.size() / (double)this.getSentenceCount()) * 1000)));
//        map.add(String.valueOf(Math.floor(((double)this.simpleSentences.size() / (double)this.getSentenceCount()) * 1000)));
//        map.add(String.valueOf(Math.floor(((double)this.unifiedSentences.size() / (double)this.getSentenceCount()) * 1000)));
//        map.add(String.valueOf(Math.floor(((double)this.verbSentences.size() / (double)this.getSentenceCount()) * 1000)));
        
        map.add(String.valueOf(Math.floor(((double)this.connectives.size() / (double)this.getWordCount()) * 100000)));
        map.add(String.valueOf(Math.floor(((double)this.nums.size() / (double)this.getWordCount()) * 1000)));
//        map.add(String.valueOf(Math.floor(((double)this.prepositions.size() / (double)this.getWordCount()) * 1000)));
        map.add(String.valueOf(Math.floor(((double)this.pronouns.size() / (double)this.getWordCount()) * 1000)));
//        map.add(String.valueOf(Math.floor(((double)this.properNouns.size() / (double)this.getWordCount()) * 1000)));
        map.add(String.valueOf(Math.floor(((double)this.questionWords.size() / (double)this.getWordCount()) * 100000)));       
        map.add(String.valueOf(Math.floor(((double)this.abbreviations.size() / (double)this.getWordCount()) * 100000)));
//        map.add(String.valueOf(Math.floor(((double)this.adjectives.size() / (double)this.getWordCount()) * 1000)));
//        map.add(String.valueOf(Math.floor(((double)this.amputations.size() / (double)this.getWordCount()) * 100000)));
//        map.add(String.valueOf(Math.floor(((double)this.errorWords.size() / (double)this.getWordCount()) * 100000)));
//        map.add(String.valueOf(Math.floor(((double)this.exclamations.size() / (double)this.getWordCount()) * 100000)));
//        map.add(String.valueOf(Math.floor(((double)this.nouns.size() / (double)this.getWordCount()) * 1000)));
        map.add(String.valueOf(Math.floor(((double)this.times.size() / (double)this.getWordCount()) * 1000)));
//        map.add(String.valueOf(Math.floor(((double)this.verbs.size() / (double)this.getWordCount()) * 1000)));
        
        map.add(String.valueOf(Math.floor(((double)this.colonSize / (double)this.getMarkCount()) * 1000)));
        map.add(String.valueOf(Math.floor(((double)this.commaSize / (double)this.getMarkCount()) * 1000)));
        map.add(String.valueOf(Math.floor(((double)this.ellipsisPointSize / (double)this.getMarkCount()) * 1000)));
        map.add(String.valueOf(Math.floor(((double)this.hypenSize / (double)this.getMarkCount()) * 1000)));
        map.add(String.valueOf(Math.floor(((double)this.pointSize / (double)this.getMarkCount()) * 1000)));
        map.add(String.valueOf(Math.floor(((double)this.quotationSize / (double)this.getMarkCount()) * 1000)));
        map.add(String.valueOf(Math.floor(((double)this.semicolonSize / (double)this.getMarkCount()) * 100000)));
        map.add(String.valueOf(Math.floor(((double)this.exlamationSize / (double)this.getMarkCount()) * 1000)));
        map.add(String.valueOf(Math.floor(((double)this.paranthesisSize / (double)this.getMarkCount()) * 1000)));
        map.add(String.valueOf(Math.floor(((double)this.questionMarkSize / (double)this.getMarkCount()) * 1000)));
        
        map.add(String.valueOf(Math.floor(((double)this.capitalLetterSize / (double)this.getArticle().getContent().length()) * 1000)));
//        map.add(String.valueOf(Math.floor(((double)this.numberSize / (double)this.getArticle().getContent().length()) * 100000)));
        
        map.add(String.valueOf(Math.floor(this.getAverageSentencesLength())));
        map.add(String.valueOf(Math.floor(this.getAverageWordCountPerSentences())));
        map.add(String.valueOf(Math.floor(this.getAverageWordLength())));
        
        map.add(String.valueOf(Math.floor(this.getDugasts() * 100)));
        map.add(String.valueOf(Math.floor(this.getGuiard() * 100)));
//        map.add(String.valueOf(Math.floor(this.getBrunet() * 10000)));
//        map.add(String.valueOf(Math.floor(this.getHerdan() * 100)));
//        map.add(String.valueOf(Math.floor(this.getJanenkov() * 10000)));
        map.add(String.valueOf(Math.floor(this.getMaas() * 100)));
        map.add(String.valueOf(Math.floor(this.getRubet() * 100)));
        map.add(String.valueOf(Math.floor(this.getSichel() * 1000)));
        
        map.add(String.valueOf(Math.floor(this.getTypeTokenRatio())));
//        map.add(String.valueOf(Math.floor(((double)this.twoTimesWordSize / (double)this.getWordCount()) * 1000)));
//        map.add(String.valueOf(Math.floor(((double)this.threeTimesWordSize / (double)this.getWordCount()) * 1000)));
//        map.add(String.valueOf(Math.floor(((double)this.fourTimesWordSize / (double)this.getWordCount()) * 10000)));
//        map.add(String.valueOf(Math.floor(((double)this.fiveTimesWordSize / (double)this.getWordCount()) * 10000)));
//        map.add(String.valueOf(Math.floor(((double)this.sixTimesWordSize / (double)this.getWordCount()) * 10000)));
        
        return map;
    }

    /**
     * ***********************************************************************
     */
    
    public ArticleOperation() {}
    
    public ArticleOperation(Article article) {
        this.article = article;
        this.sentences = new ArrayList<>();
        this.words = new ArrayList<>();
        this.differentWords = new HashSet<>();
        
        splitToSentences(this.article);
        splitToWords();
        getWordCountNTimes();
        calculateSentenceTypes();
        calculateWordTypes();
        calculateMarkTypes();
    }

    public Article getArticle() {
        return article;
    }

    public List<String> getSentences() {
        return sentences;
    }

    public List<String> getWords() {
        return words;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    /**
     * ***********************************************************************
     */
    
    public int getSentenceCount() {
        return sentences.size();
    }

    public int getWordCount() {
        return words.size();
    }   
    
    /**
     * ***********************************************************************
     */
    
    public double getTypeTokenRatio() {
        return ((double) this.differentWords.size() / (double) getWordCount()) * 100;
    }
    
    public double getAverageSentencesLength() {
        return average(sentences);
    }
    
    public double getAverageWordLength() {
        return average(words);
    }

    public double getAverageWordCountPerSentences() {
        double sum = 0.00;
        for (String sentence : sentences) {
            sum += sentence.split(" ").length;
        }

        return sum / sentences.size();
    }

    /**
     * ***********************************************************************
     */
    
    public List<String> getSentences(SentenceType sentenceType) {
        switch (sentenceType.getName()) {                
            case "QUESTION":
                return getQuestionSentences();
            case "EXCLAMATION":
                return getExclamationSentences();
            case "INVERSE":
                return getInverseSentences();
            case "NOUN":
                return getNounSentences();   
            case "POSITIVE":
                return getPositiveSentences();
            case "NEGATIF":
                return getNegatifSentences();
            case "REGULAR":
                return getRegularSentences();
            case "VERB":
                return getVerbSentences();
            case "SIMPLE":
                return getSimpleSentences();
            case "UNIFIED":
                return getUnifiedSentences();
            default:
                return null;    
        }
    }

    public int getSentenceCount(SentenceType sentenceType) {
        switch (sentenceType.getName()) {                
            case "QUESTION":
                return getQuestionSentenceCount();
            case "EXCLAMATION":
                return getExclamationSentenceCount();
            case "INVERSE":
                return getInverseSentenceCount();
            case "NOUN":
                return getNounSentenceCount();   
            case "POSITIVE":
                return getPositiveSentenceCount();
            case "NEGATIF":
                return getNegatifSentenceCount();
            case "REGULAR":
                return getRegularSentenceCount();
            case "VERB":
                return getVerbSentenceCount();
            case "SIMPLE":
                return getSimpleSentenceCount();
            case "UNIFIED":
                return getUnifiedSentenceCount();
            default:
                return 0;    
        }
    }

    public List<String> getWords(WordType wordType) {
        switch (wordType.getName()) {                
            case "PRONOUN":
                return this.getPronouns();
            case "QUESTION_WORD":
                return this.getQuestionWords();
            case "PREPOSITION":
                return this.getPrepositions();
            case "CONNECTIVE":
                return this.getConnectives();
            case "PROPER_NOUN":
                return this.getProperNouns();
            case "NUMBER":
                return this.getNums();   
            case "VERB":
                return this.getVerbs();
            case "NOUN":
                return this.getNouns();
            case "ADJECTIVE":
                return this.getAdjectives();
            case "ERROR_WORD":
                return this.getErrorWords();
            case "ABBREVIATION":
                return this.getAbbreviations();
            case "EXCLAMATION":
                return this.getExclamations();
            case "AMPUTATION":
                return this.getAmputations();
            case "TIME":
                return this.getTimes();
            default:
                return null;    
        }
    }

    public int getWordCount(WordType wordType) {
        switch (wordType.getName()) {                
            case "PRONOUN":
                return this.getPronounCount();
            case "QUESTION_WORD":
                return this.getQuestionWordCount();
            case "PREPOSITION":
                return this.getPrepositionCount();
            case "CONNECTIVE":
                return this.getConnectiveCount();
            case "PROPER_NOUN":
                return this.getProperNounCount();
            case "NUMBER":
                return this.getNumCount();                                  
            case "VERB":
                return this.getVerbCount();
            case "NOUN":
                return this.getNounCount();
            case "ADJECTIVE":
                return this.getAdjectiveCount();
            case "ERROR_WORD":
                return this.getErrorWordCount();
            case "ABBREVIATION":
                return this.getAbbreviationCount();
            case "EXCLAMATION":
                return this.getExclamationCount();
            case "AMPUTATION":
                return this.getAmputationCount();
            case "TIME":
                return this.getTimeCount();
            default:
                return 0;    
        }
    }

    public int getMarkCount(MarkType markType) {
        switch (markType.getName()) {                
            case "POINT":
                return this.pointSize;
            case "COMMA":
                return this.commaSize;
            case "COLON":
                return this.colonSize;
            case "SEMICOLON":
                return this.semicolonSize;
            case "HYPEN":
                return this.hypenSize;
            case "QUOTATION":
                return this.quotationSize;
            case "ELLİPSIS_POINT":
                return this.ellipsisPointSize;
            case "QUESTION_MARK":
                return this.questionMarkSize;
            case "EXCLAMATION_MARK":
                return this.exlamationSize;
            case "PARANTHESIS":
                return this.paranthesisSize;
            default:
                return 0;    
        }
    }

    public int getMarkCount() {
        return this.colonSize + this.commaSize + this.ellipsisPointSize + this.exlamationSize + this.hypenSize
                + this.paranthesisSize + this.pointSize + this.questionMarkSize + this.quotationSize + this.semicolonSize;
    }

    /**
     * ***********************************************************************
     */
    
    public int getCapitalLetterCount() {
        return this.capitalLetterSize;
    }
    
    public int getNumberCount() {
        return this.numberSize;
    }

    /**
     * ***********************************************************************
     */
    
    public double getGuiard() {
//        double left = (double) getWordCount();
//        double right = Math.sqrt((double) differentWords.size());        
//                
//        if(right == 0)
//            return 0;
//        
//        return left / right;
        
        double V = (double)differentWords.size() + getNTimesWordCount(2);
        double N = (double)getWordCount();
        
        double right = Math.pow(N, 0.5);        
        if(right == 0)
            return 0;
            
        return V / right;
    }

    public double getDugasts() {
//        double left = Math.pow(Math.log10((double) differentWords.size()), 2);
//        double right1 = Math.log10((double) differentWords.size());
//        double right2 = Math.log10((double) getWordCount()); 
//        
//        if(right2 == 0)
//            return 0;
//        double right = right1 / right2;
//                
//        if(right == 0)
//            return 0;
//        
//        return left / right;
        
        double V = (double)differentWords.size() + getNTimesWordCount(2);
        double N = (double)getWordCount();
        
        double left = Math.pow(Math.log10(N), 2);
        double right = (Math.log10(N)/Math.log10(V));        
        if(right == 0)
            return 0;
        
        return left / right;
    }
    
    public double getRubet() {
//        double left = Math.log10((double) getWordCount());
//        double right = Math.log10(Math.log10((double) differentWords.size()));
//                
//        if(right == 0)
//            return 0;
//        
//        return left / right;
        
        double V = (double)differentWords.size() + getNTimesWordCount(2);
        double N = (double)getWordCount();
        
        double left = Math.log10(V);
        double right = Math.log10(Math.log10(N));        
        if(right == 0)
            return 0;
        
        return left / right;
    }

    public double getMaas() {
//        double left = Math.sqrt(1.0 / getHerdan());
//        double right = Math.pow(Math.log10((double) differentWords.size()), 2);
//                
//        if(right == 0)
//            return 0;
//        
//        return left / right;
        
        double V = (double)differentWords.size() + getNTimesWordCount(2);
        double N = (double)getWordCount();
        
        double left = (Math.log10(N)/Math.log10(V));
        double right = Math.pow((Math.log10(N)), 2);        
        if(right == 0)
            return 0;
        
        return Math.pow((left / right), 0.5);
    }

    public double getJanenkov() {
//        double left = 1.0;
//        double right = (Math.pow((double) getWordCount(), 2) * Math.log10((double) differentWords.size()));
//                
//        if(right == 0)
//            return 0;
//        
//        return left / right;
        
        double V = (double)differentWords.size() + getNTimesWordCount(2);
        double N = (double)getWordCount();
        
        double left = Math.pow(V, 2);
        double right = Math.log10(N);        
        if(left * right == 0)
            return 0;
        
        return 1.0 / (left * right);
    }

    public double getBrunet() {      
//        double left = (double) differentWords.size();
//        double right = ((double) getWordCount() / 0.172);
//        
//        if(right == 0)
//            return 0;
//        
//        return left / right;
       
        return 0;
        
//        double V = (double)differentWords.size() + getNTimesWordCount(2);
//        double N = (double)getWordCount();
//        
//        double right = V/0.172;
//        if(right < 0.0001)
//            return 0;
//        
//        return Math.pow(N, right);
    }

    public double getHerdan() {
//        double left = Math.log10((double) getWordCount());
//        double right = Math.log10((double) differentWords.size());
//                
//        if(right == 0)
//            return 0;        
//        
//        return left / right;
        
        double V = (double)differentWords.size() + getNTimesWordCount(2);
        double N = (double)getWordCount();
        
        double left = Math.log10(V);
        double right = Math.log10(N);        
        if(right == 0)
            return 0;
        
        return left / right;
    }
    
    public double getSichel() {
//        double twice = getNTimesWordCount(2);
//        
//        return twice / this.differentWords.size();
        
        double twice = getNTimesWordCount(2);
        double V = twice + (double)this.differentWords.size();
      
        if(V == 0)
            return 0;
        
        return twice/V;
    }

    /**
     * ***********************************************************************
     */
    
    private void getWordCountNTimes() {
        String[] nTimesWords = new String[words.size()];
        int nTimesWordsSize = 0;
        String[] wordList = new String[words.size()];
        for (int i = 0; i < wordList.length; i++) {
            wordList[i] = words.get(i).toLowerCase();
        }

        Arrays.sort(wordList);

        int temp = 0;
        for (int i = 0; i < wordList.length-1; i++) {
            for (int j = i; j < wordList.length; j++) {
                if (wordList[i].equals(wordList[j])) {
                    temp++;
                }else{
                    break;
                }
            }
            
            boolean isExist = false;
            for (int k = 0; k < nTimesWordsSize; k++) {
                if (nTimesWords[k].equals(wordList[i])) {
                    isExist = true;
                    break;
                }
            }

            if (isExist == false) {
                nTimesWords[nTimesWordsSize] = wordList[i];
                nTimesWordsSize++;
                if(temp == 2){
                    this.twoTimesWordSize++;
                }else if(temp == 3){
                    this.threeTimesWordSize++;
                }else if(temp == 4){
                    this.fourTimesWordSize++;
                }else if(temp == 5){
                    this.fiveTimesWordSize++;
                }else if(temp == 6){
                    this.sixTimesWordSize++;
                } 
            }

            temp = 0;
        } 
    }
    
    public int getNTimesWordCount(int times){
        if(times == 2){
            return this.twoTimesWordSize;
        }else if(times == 3){
            return this.threeTimesWordSize;
        }else if(times == 4){
            return this.fourTimesWordSize;
        }else if(times == 5){
            return this.fiveTimesWordSize;
        }else if(times == 6){
            return this.sixTimesWordSize;
        }else{
            return 0;
        } 
    } 

    /**
     * ***********************************************************************
     */
    
    private void splitToSentences(Article article) {
        int start = 0;
        int articleContentSize = article.getContent().length();
        StringBuilder sentence = new StringBuilder();
        String marks = ".!?:;";
        List<Integer> startIndexs = new ArrayList<>();
        List<Integer> finishIndexs = new ArrayList<>();

        for (int i = 0; i < articleContentSize; i++) {
            if (marks.contains(String.valueOf(article.getContent().charAt(i))) && !isAbreveation(getWordBeforeMark(article.getContent(), i))) {
                sentence.append(article.getContent().substring(start, i + 1).trim());
                if (isSentence(sentence.toString())) {
                    if(sentence.charAt(0) == '.'){
                        sentences.add(sentence.toString().substring(3));
                    }else{
                        sentences.add(sentence.toString());
                    }
                }
                sentence.delete(0, sentence.length());
                start = i + 1;
            }else if(article.getContent().charAt(i) == '"'){
                sentence.append(article.getContent().substring(start, i + 1).trim()).append(" ");
                startIndexs.add(i);
                i++;
                if(i < articleContentSize - 1){
                    while(i<articleContentSize && article.getContent().charAt(i) != '"'){
                        i++;
                    }
                }
                
                if(i < articleContentSize-1){
                    finishIndexs.add(i);
                    start = i + 1;  
                }else{
                    finishIndexs.add(articleContentSize-1);
                    start = articleContentSize-1;
                }
            }
        }
       
        List<String> quataSentences;
        for (int i = 0; i < finishIndexs.size(); i++) {
            if(marks.contains(String.valueOf(article.getContent().charAt(finishIndexs.get(i)-1)))){
                quataSentences = splitToSentencesQ(new Article("",article.getContent().substring(startIndexs.get(i)+1, finishIndexs.get(i)),null));
                for (int j = 0; j < quataSentences.size(); j++) {
                    sentences.add(quataSentences.get(j));
                }
            }
        }
    }
    
    private List<String> splitToSentencesQ(Article article) {
        int start = 0;
        int articleContentSize = article.getContent().length();
        StringBuilder sentence = new StringBuilder();
        String marks = ".!?:;";
        List<Integer> startIndexs = new ArrayList<>();
        List<Integer> finishIndexs = new ArrayList<>();

        List<String> tempSentences = new ArrayList<>();
        for (int i = 0; i < articleContentSize; i++) {
            if (marks.contains(String.valueOf(article.getContent().charAt(i))) && !isAbreveation(getWordBeforeMark(article.getContent(), i))) {
                sentence.append(article.getContent().substring(start, i + 1).trim());
                if (isSentence(sentence.toString())) {
                    if(sentence.charAt(0) == '.'){
                        tempSentences.add(sentence.toString().substring(3));
                    }else{
                        tempSentences.add(sentence.toString());
                    }
                }
                sentence.delete(0, sentence.length());
                start = i + 1;
            }else if(article.getContent().charAt(i) == '"'){
                sentence.append(article.getContent().substring(start, i + 1).trim()).append(" ");
                startIndexs.add(i);
                i++;
                if(i < articleContentSize - 1){
                    while(i<articleContentSize && article.getContent().charAt(i) != '"'){
                        i++;
                    }
                }
                
                if(i < articleContentSize-1){
                    finishIndexs.add(i);
                    start = i + 1;  
                }else{
                    finishIndexs.add(articleContentSize-1);
                    start = articleContentSize-1;
                }
            }
        }
       
        List<String> quataSentences;
        for (int i = 0; i < finishIndexs.size(); i++) {
            if(marks.contains(String.valueOf(article.getContent().charAt(finishIndexs.get(i)-1)))){
                quataSentences = splitToSentencesQ(new Article("",article.getContent().substring(startIndexs.get(i)+1, finishIndexs.get(i)),null));
                for (int j = 0; j < quataSentences.size(); j++) {
                    tempSentences.add(quataSentences.get(j));
                }
            }
        }

        return tempSentences;
    }

    private void splitToWords() {
        String[] wordList = article.getContent().replaceAll(",", " ").replaceAll("\\?", " ").replaceAll("!", " ").replaceAll("\\.", " ").replaceAll("\"", " ").replaceAll(":", " ").replaceAll(";", " ").replaceAll("'", " ").replaceAll("\n", " ").split(" ");
        for (String word : wordList) {
            if (!word.equals("") && zb.isTurkish(word)) {
                words.add(word);
                differentWords.add(word.toLowerCase());
            }
        }
    }

    private void calculateSentenceTypes() {        
        String[] sentenceTypes;
        for (int i = 0; i < sentences.size(); i++) {
            sentenceTypes = calculateSentenceType(sentences.get(i));
            for (int j = 0; j < sentenceTypes.length; j++) {
                if (sentenceTypes[j].equals(SentenceType.EXCLAMATION.getName())) {
                    this.exclamationSentences.add(sentences.get(i));
                } else if (sentenceTypes[j].equals(SentenceType.INVERSE.getName())) {
                    this.inverseSentences.add(sentences.get(i));
                } else if (sentenceTypes[j].equals(SentenceType.NOUN.getName())) {
                    this.nounSentences.add(sentences.get(i));
                } else if (sentenceTypes[j].equals(SentenceType.QUESTION.getName())) {
                    this.questionSentences.add(sentences.get(i));  
                } else if (sentenceTypes[j].equals(SentenceType.NEGATIF.getName())) {
                    this.negatifSentences.add(sentences.get(i));
                } else if (sentenceTypes[j].equals(SentenceType.POSITIVE.getName())) {
                    this.positiveSentences.add(sentences.get(i));
                } else if (sentenceTypes[j].equals(SentenceType.REGULAR.getName())) {
                    this.regularSentences.add(sentences.get(i));
                } else if (sentenceTypes[j].equals(SentenceType.SIMPLE.getName())) {
                    this.simpleSentences.add(sentences.get(i));
                } else if (sentenceTypes[j].equals(SentenceType.UNIFIED.getName())) {
                    this.unifiedSentences.add(sentences.get(i));
                } else if (sentenceTypes[j].equals(SentenceType.VERB.getName())) {
                    this.verbSentences.add(sentences.get(i));
                } 
            }  
        }       
    }

    private void calculateWordTypes() {
        String wordType = "";
        String[] types;
        String afterWord = "";
        for (int i = 0; i < words.size(); i++) {     
            if (i < words.size() - 1) {
                afterWord = words.get(i + 1);
            } else {
                afterWord = "";
            }
            
            if(isNumeric(words.get(i))){
                this.numberSize++;
            }
            
            types = zb.getRootTypes(words.get(i));
            Kelime[] parsed = zb.parse(words.get(i));
            
            wordType = calculateWordType(words.get(i), afterWord, types, parsed);            
            if(wordType == null){
                
            } else if (wordType.equals(WordType.CONNECTIVE.getName())) {
                this.connectives.add(words.get(i));
            } else if (wordType.equals(WordType.NUMBER.getName())) {
                this.nums.add(words.get(i));
            } else if (wordType.equals(WordType.PREPOSITION.getName())) {
                this.prepositions.add(words.get(i));
            } else if (wordType.equals(WordType.PRONOUN.getName())) {
                this.pronouns.add(words.get(i));
            } else if (wordType.equals(WordType.PROPER_NOUN.getName())) {
                this.properNouns.add(words.get(i));
            } else if (wordType.equals(WordType.QUESTION_WORD.getName())) {
                this.questionWords.add(words.get(i));
            } else if (wordType.equals(WordType.VERB.getName())) {
                this.verbs.add(words.get(i));
            } else if (wordType.equals(WordType.ADJECTIVE.getName())) {
                this.adjectives.add(words.get(i));
            } else if (wordType.equals(WordType.ABBREVIATION.getName())) {
                this.abbreviations.add(words.get(i));
            } else if (wordType.equals(WordType.AMPUTATION.getName())) {
                this.amputations.add(words.get(i));
            } else if (wordType.equals(WordType.ERROR_WORD.getName())) {
                this.errorWords.add(words.get(i));
            } else if (wordType.equals(WordType.EXCLAMATION.getName())) {
                this.exclamations.add(words.get(i));
            } else if (wordType.equals(WordType.TIME.getName())) {
                this.times.add(words.get(i));
            } else if (wordType.equals(WordType.NOUN.getName())) {
                this.nouns.add(words.get(i));
            }
        }
    }

    private void calculateMarkTypes() {
        int contentSize = this.article.getContent().length();
        String content = this.article.getContent();
        for (int i = 0; i < contentSize; i++) {
            switch (content.charAt(i)) {
                case '.':
                    if(i < contentSize-2){
                        if(content.charAt(i+1) == '.' && content.charAt(i+2) == '.'){
                            this.ellipsisPointSize++;
                        }else{
                            this.pointSize++;
                        }
                    }
                    break;
                case ',':
                    this.commaSize++;
                    break;
                case ':':
                    this.colonSize++;
                    break;
                case ';':
                    this.semicolonSize++;
                    break;
                case '?':
                    this.questionMarkSize++;
                    break;
                case '-':
                    this.hypenSize++;
                    break;
                case '!':
                    this.exlamationSize++;
                    break;
                case '(':
                case ')':
                case '[':
                case ']':
                    this.paranthesisSize++;
                    break;
                case '"':
                case '\'':
                    this.quotationSize++;
                    break;    
            }           
            
            if(this.article.getContent().charAt(i) >= 65 && this.article.getContent().charAt(i) <= 90){
                this.capitalLetterSize++;
            }
        }
    }    
    
    private String[] calculateSentenceType(String sentence) {
        String[] types = new String[5];
        int count = 0;
        
        if (isExclamationSentence(sentence)) {
            types[count] = SentenceType.EXCLAMATION.getName();
            count++;
        }else if (isQuestionSentence(sentence)) {
            types[count] = SentenceType.QUESTION.getName();
            count++;
        }else{
            types[count] = "";
            count++;
        }

        if (isNounSentence(sentence)) {
            types[count] = SentenceType.NOUN.getName();
            count++;
        }else if (isVerbSentence(sentence)) {
            types[count] = SentenceType.VERB.getName();
            count++;
        }else{
            types[count] = "";
            count++;
        }

        if (isPositiveSentence(sentence)) {
            types[count] = SentenceType.POSITIVE.getName();
            count++;
        }else if (isNegatifSentence(sentence)) {
            types[count] = SentenceType.NEGATIF.getName();
            count++;
        }else{
            types[count] = "";
            count++;
        }

        if (isRegularSentence(sentence)) {
            types[count] = SentenceType.REGULAR.getName();
            count++;
        }else if (isInverseSentence(sentence)) {
            types[count] = SentenceType.INVERSE.getName();
            count++;
        }else{
            types[count] = "";
            count++;
        }

        if (isSimpleSentence(sentence)) {
            types[count] = SentenceType.SIMPLE.getName();
            count++;
        }else if (isUnifiedSentence(sentence)) {
            types[count] = SentenceType.UNIFIED.getName();
            count++;
        }else{
            types[count] = "";
            count++;
        }

        return types;
    }

    private String calculateWordType(String word, String afterWord, String[] types, Kelime[] parsed) {        
        if (isAbreveation(word) || isAbbreviation(word, types)) {
            return WordType.ABBREVIATION.getName();
        } else if (isVerb(word, types, parsed)) {
            return WordType.VERB.getName();
        } else if (isAdjective(word, afterWord, types, parsed)) {
            return WordType.ADJECTIVE.getName();
        } else if (isAmputation(word, types)) {
            return WordType.AMPUTATION.getName();
        } else if (isConnective(word, types)) {
            return WordType.CONNECTIVE.getName();
        } else if (isExclamation(word, types)) {
            return WordType.EXCLAMATION.getName();
        } else if (isNum(word, afterWord, types)) {
            return WordType.NUMBER.getName();
        } else if (isPreposition(word, types)) {
            return WordType.PREPOSITION.getName();
        } else if (isPronoun(word, types)) {
            return WordType.PRONOUN.getName();
        } else if (isProperNoun(word, types)) {
            return WordType.PROPER_NOUN.getName();
        } else if (isQuestionWord(word, types)) {
            return WordType.QUESTION_WORD.getName();
        } else if (isTime(word, types)) {
            return WordType.TIME.getName();
        } else if (isErrorWord(word, types)) {
            return WordType.ERROR_WORD.getName();
        } else if (isNoun(word, types, parsed)) {
            return WordType.NOUN.getName();
        }
        
        return null;
    }

    /**
     * ***********************************************************************
     */
    
    private boolean isAbreveation(String word) {
        boolean inList = false;
        for (String s : abreveationList) {
            if (word.toUpperCase().equals(s)) {
                inList = true;
                break;
            }
        }
        return inList || (!zb.isTurkish(word) && word.length() < 5);
    }

    private String getWordBeforeMark(String content, int index) {
        String marks = ".,!?:;@ ";
        int i = 0;
        if(index > 0){
            for (i = index - 1; !marks.contains(String.valueOf(content.charAt(i))) && i > 0; i--);
        }

        if(i+1 < index){
            return content.substring(i + 1, index);
        }else{
            return "";
        }        
    }

    private boolean isSentence(String text) {
        return text.length() > 3;
    }
    
    private boolean isNumeric(String s) {
        if (s.length() < 2) {
            return s.matches("[-+]?\\d*\\.?\\d+");
        } else {
            return s.matches("[-+]?\\d*\\.?\\d+") || s.substring(0, s.length() - 1).matches("[-+]?\\d*\\.?\\d+");
        }
    }

    private double average(List<String> list) {
        double sum = 0.00;
        for (String l : list) {
            sum += l.length();
        }

        return sum / list.size();
    }

    /**
     * ***********************************************************************
     */
    
    public List<String> getQuestionSentences() {
        return this.questionSentences;
    }

    public int getQuestionSentenceCount() {
        return getQuestionSentences().size();
    }

    public List<String> getExclamationSentences() {
        return this.exclamationSentences;
    }

    public int getExclamationSentenceCount() {
        return getExclamationSentences().size();
    }

    public List<String> getPositiveSentences() {
        return this.positiveSentences;
    }

    public int getPositiveSentenceCount() {
        return getPositiveSentences().size();
    }

    public List<String> getNegatifSentences() {
        return this.negatifSentences;
    }

    public int getNegatifSentenceCount() {
        return getNegatifSentences().size();
    }

    public List<String> getRegularSentences() {
        return this.regularSentences;
    }

    public int getRegularSentenceCount() {
        return getRegularSentences().size();
    }

    public List<String> getInverseSentences() {
        return this.inverseSentences;
    }

    public int getInverseSentenceCount() {
        return getInverseSentences().size();
    }

    public List<String> getVerbSentences() {
        return this.verbSentences;
    }

    public int getVerbSentenceCount() {
        return getVerbSentences().size();
    }

    public List<String> getNounSentences() {
        return this.nounSentences;
    }

    public int getNounSentenceCount() {
        return getNounSentences().size();
    }

    public List<String> getSimpleSentences() {
        return this.simpleSentences;
    }

    public int getSimpleSentenceCount() {
        return getSimpleSentences().size();
    }

    public List<String> getUnifiedSentences() {
        return this.unifiedSentences;
    }

    public int getUnifiedSentenceCount() {
        return getUnifiedSentences().size();
    }

    /**
     * ***********************************************************************
     */

    public List<String> getVerbs() {
        return this.verbs;
    }

    public int getVerbCount() {
        return getVerbs().size();
    }

    public List<String> getNouns() {
        return this.nouns;
    }

    public int getNounCount() {
        return getNouns().size();
    }

    public List<String> getAdjectives() {
        return this.adjectives;
    }

    public int getAdjectiveCount() {
        return getAdjectives().size();
    }

    public List<String> getPronouns() {
        return this.pronouns;
    }

    public int getPronounCount() {
        return getPronouns().size();
    }

    public List<String> getQuestionWords() {
        return this.questionWords;
    }

    public int getQuestionWordCount() {
        return getQuestionWords().size();
    }

    public List<String> getPrepositions() {
        return this.prepositions;
    }

    public int getPrepositionCount() {
        return getPrepositions().size();
    }

    public List<String> getConnectives() {
        return this.connectives;
    }

    public int getConnectiveCount() {
        return getConnectives().size();
    }

    public List<String> getErrorWords() {
        return this.errorWords;
    }

    public int getErrorWordCount() {
        return getErrorWords().size();
    }

    public List<String> getAbbreviations() {
        return this.abbreviations;
    }

    public int getAbbreviationCount() {
        return getAbbreviations().size();
    }

    public List<String> getProperNouns() {
        return this.properNouns;
    }

    public int getProperNounCount() {
        return getProperNouns().size();
    }

    public List<String> getNums() {
        return this.nums;
    }

    public int getNumCount() {
        return getNums().size();
    }

    public List<String> getExclamations() {
        return this.exclamations;
    }

    public int getExclamationCount() {
        return getExclamations().size();
    }

    public List<String> getAmputations() {
        return this.amputations;
    }

    public int getAmputationCount() {
        return getAmputations().size();
    }

    public List<String> getTimes() {
        return this.times;
    }

    public int getTimeCount() {
        return getTimes().size();
    }
    
    /**
     * ***********************************************************************
     */        

    public boolean isConnective(String word, String[] types) {
        for (String type : types) {
            if (type.equals("BAGLAC") || word.equals("ve") || word.equals("de") || word.equals("ki") || word.equals("ile")
                            || word.equals("ancak") || word.equals("fakat") || word.equals("veya") || word.equals("lakin")) {
                return true;
            }
        }
        return false;
    }

    public boolean isNum(String word, String afterWord, String[] types) {
        for (String type : types) {
            if (type.equals("SAYI")) {
                return true;
            }
        }
        return false;
    }

    public boolean isPreposition(String word, String[] types) {
        for (String type : types) {
            if (type.equals("EDAT")) {
                return true;
            }
        }
        return false;
    }

    public boolean isPronoun(String word, String[] types) {
        for (String type : types) {
            if (type.equals("ZAMIR")) {
                return true;
            }
        }
        return false;
    }

    public boolean isProperNoun(String word, String[] types) {
        for (String type : types) {
            if (type.equals("OZEL")) {
                return true;
            }
        }
        return false;
    }

    public boolean isQuestionWord(String word, String[] types) {
        for (String type : types) {
            if (type.equals("SORU")) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isVerb(String word, String[] types, Kelime[] parsed) {
        int i = 0;
        Ek[] insets = null;
        for (String type : types) {
            insets = zb.getInsets(parsed[i]);

            if (type.equals("FIIL")) {
                if (insets.length == 1) {
                    return true;
                }

                for (Ek e : insets) {
                    if (e.ad().contains("ZAMAN")) {
                        return true;
                    }
                }
            } else if (type.equals("ISIM")) {
                for (Ek e : insets) {
                    if (e.ad().contains("ISIM_TANIMLAMA")) {
                        return true;
                    }
                }
            }

            i++;
        }

        return false;
    }
    
    public boolean isAbbreviation(String word, String[] types) {
        for (String type : types) {
            if (type.equals("KISALTMA")) {
                return true;
            }
        }
        return false;
    }

    public boolean isAdjective(String word, String afterWord, String[] types, Kelime[] parsed) {
        int affixCount = 0;
        for (Kelime w : parsed) {
            if (zb.getInsetCount(w) != 0) {
                affixCount = zb.getInsetCount(w);
                break;
            }
        }

        int i = 0;
        for (String type : types) {
            if (type.equals("SIFAT") && affixCount == 1) {
                return true;
            } else if (type.equals("FIIL")) {
                Ek[] insets = zb.getInsets(parsed[i]);
                for (Ek e : insets) {
                    if (e.ad().contains("FIIL_DONUSUM_EN") || e.ad().contains("FIIL_DONUSUM_ESI")
                            || e.ad().contains("FIIL_DONUSUM_MEZ") || e.ad().contains("FIIL_DONUSUM_ER")
                            || e.ad().contains("FIIL_DONUSUM_DIK") || e.ad().contains("FIIL_DONUSUM_ECEK")
                            || e.ad().contains("FIIL_DONUSUM_MIS")) {
                        return true;
                    }
                }
            }
            i++;
        }
        return false;
    }

    public boolean isAmputation(String word, String[] types) {
        for (String type : types) {
            if (type.equals("YANKI")) {
                return true;
            }
        }
        return false;
    }

    public boolean isErrorWord(String word, String[] types) {
        for (String type : types) {
            if (type.equals("HATALI")) {
                return true;
            }
        }
        return false;
    }

    public boolean isExclamation(String word, String[] types) {
        for (String type : types) {
            if (type.equals("UNLEM")) {
                return true;
            }
        }
        return false;
    }

    public boolean isNoun(String word, String[] types, Kelime[] parsed) {
        Kelime[] wordArray = zb.parse(word);
        int affixCount = 0;
        for (Kelime w : wordArray) {
            if (zb.getInsetCount(w) != 0) {
                affixCount = zb.getInsetCount(w);
                break;
            }
        }

        for (String type : types) {
            if (type.equals("ISIM") || (type.equals("SIFAT") && affixCount != 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTime(String word, String[] types) {
        for (String type : types) {
            if (type.equals("ZAMAN")) {
                return true;
            }
        }
        return false;
    }

    /**
     * ***********************************************************************
     */

    public boolean isExclamationSentence(String sentence) {
        return sentence.contains("!");
    }
    
    public boolean isQuestionSentence(String sentence) {
        if(sentence.equals("")){
            return false;
        }
        
        String[] wordList = sentence.substring(0, sentence.length() - 1).split(" ");
        String[] types = null;
        for (int i = 0; i < wordList.length; i++) {
            types = zb.getRootTypes(wordList[i]);
            if (this.isQuestionWord(wordList[i], types)) {
                return true;
            }
        }

        return sentence.contains("?");
    }

    public boolean isNounSentence(String sentence) {
        //Cümlenin yüklemi isim olmalıdır.
        if(sentence.equals("")){
            return false;
        }
        
        return !this.isVerbSentence(sentence);
    }
    
    public boolean isVerbSentence(String sentence) {
        //Cümlenin yüklemi fiil olmalıdır.
        if(sentence.equals("")){
            return false;
        }
        
        String[] wordList = sentence.substring(0, sentence.length() - 1).split(" ");
        Kelime[] parsed = null;
        String[] types = null;
        Ek[] insets = null;
        for (int i = 0; i < wordList.length; i++) {
            parsed = zb.parse(wordList[i]);
            types = zb.getRootTypes(wordList[i]);
            if (this.isVerb(wordList[i], types, parsed)) {                
                int k = 0;
                for (String type : types) {
                    insets = zb.getInsets(parsed[k]);

                    if (type.equals("FIIL")) {
                        if (insets.length == 1) {
                            return true;
                        }

                        for (Ek e : insets) {
                            if (e.ad().contains("ZAMAN")) {
                                return true;
                            }
                        }
                    }

                    k++;
                }
            }
        }

        return false;
    }

    public boolean isInverseSentence(String sentence) {
        //Cümle yüklemi sonda olmamalıdır.
        if(sentence.equals("")){
            return false;
        }
        
        String[] wordList = sentence.substring(0, sentence.length() - 1).split(" ");
        
        Kelime[] parsed = zb.parse(wordList[wordList.length - 1]);
        String[] types = zb.getRootTypes(wordList[wordList.length - 1]);
        
        return !this.isVerb(wordList[wordList.length - 1], types, parsed);
    }
    
    public boolean isNegatifSentence(String sentence) {
        //Cümle yüklemi olmsuzluk eki içermelidir.
        if(sentence.equals("")){
            return false;
        }
        
        String[] wordList = sentence.substring(0, sentence.length() - 1).split(" ");
        Kelime[] parsed = null;
        String[] types = null;
        Ek[] insets = null;
        for (int i = 0; i < wordList.length; i++) {           
            if (wordList[i].contains("değil") || wordList[i].contains("yok") && 
                    !(wordList[i].contains("değil") && wordList[i].contains("yok"))) {
                return true;
            }           

            parsed = zb.parse(wordList[i]);
            types = zb.getRootTypes(wordList[i]);

            int k = 0;
            for (String type : types) {
                insets = zb.getInsets(parsed[k]);

                if (type.equals("FIIL")) {
                    for (Ek e : insets) {
                        if (e.ad().contains("OLUMSUZLUK_ME")) {
                            return true;
                        }
                    }
                }

                k++;
            }
        }

        return false;
    }

    public boolean isPositiveSentence(String sentence) {
        //Cümle yüklemi olmsuzluk eki içermemelidir. 
        if(sentence.equals("")){
            return false;
        }
        
        return !this.isNegatifSentence(sentence);
    }

    public boolean isRegularSentence(String sentence) {
        //Cümle fiil ile bitmelidir
        if(sentence.equals("")){
            return false;
        }
        
        String[] wordList = sentence.substring(0, sentence.length() - 1).split(" ");
        
        Kelime[] parsed = zb.parse(wordList[wordList.length - 1]);
        String[] types = zb.getRootTypes(wordList[wordList.length - 1]);
        
        return this.isVerb(wordList[wordList.length - 1], types, parsed);
    }

    public boolean isSimpleSentence(String sentence) {
        //Cümle içinde bağlaç olmamalıdır.
        if(sentence.equals("")){
            return false;
        }
        
        return !this.isUnifiedSentence(sentence);
    }

    public boolean isUnifiedSentence(String sentence) {
        //Cümle içinde bağlaç olmalıdır.
        if(sentence.equals("")){
            return false;
        }
        
        String[] wordList = sentence.substring(0, sentence.length() - 1).split(" ");
        Kelime[] parsed = null;
        String[] types = null;
        int verbCount = 0;
        for (int i = 0; i < wordList.length; i++) {
            parsed = zb.parse(wordList[i]);
            types = zb.getRootTypes(wordList[i]);

            if (this.isVerb(wordList[i], types, parsed)) {
                verbCount++;
            }
        }

        return verbCount >= 2;
    }
}    
