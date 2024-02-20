package fr.norsys.stringcalculator;

public class Clazz {

    public static int add(String numbers){
        if(numbers.length() == 0) return 0;
        String delimiter = "[,\\n]";
        String word = numbers;
        if(numbers.length() > 1 && numbers.substring(0,2).equals("//")){
            String parteOne = numbers.split("\n",2)[0];
            String parteTwo = numbers.split("\n",2)[1];
            if(parteOne.split("//").length == 0){
                delimiter = "\n";
                word = parteTwo.split("\n",2)[1];
            } else {
                delimiter = parteOne.split("//")[0];
                word = parteTwo;
            }
        }
        if(delimiter.contains("*")) delimiter = delimiter.substring(1,delimiter.length()-1);
        String[] nums = word.split(delimiter);
        int sum = 0;
        String negatives = "";
        for (String s: nums) {
            int i = Integer.valueOf(s);
            if(i > 1000) continue;
            else if(i < 0) negatives += i+" ";
            else sum += Integer.valueOf(s);
        }
        if(negatives.length() > 0) throw new RuntimeException("negatives not allowed - "+negatives);
        return sum;
    }
}