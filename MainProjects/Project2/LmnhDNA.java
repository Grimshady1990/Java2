import java.util.ArrayList;

public class LmnhDNA{

    public void dna1(){
        String dna = "ATGCGATACGCTTGA";
        int length = dna.length();
        int start = dna.indexOf("ATG");
        int end = dna.indexOf("TGA");
        if (start != -1 && end != -1 && (start - end) % 3 == 0){
            String protein = dna.substring(start, end+3);
            System.out.println("DNA SAMPLE: " + dna + " | LENGTH: " + length);
            System.out.println("PROTEIN FOUND: " + protein);
        }
        else{
            System.out.println("DNA SAMPLE: " + dna + " | LENGTH: " + length);
            System.out.println("NO PROTEIN FOUND!");
        }
    }
    public void dna2(){
        String dna = "ATGCGATACGTGA";
        int length = dna.length();
        int start = dna.indexOf("ATG");
        int end = dna.indexOf("TGA");
        if (start != -1 && end != -1 && (start - end) % 3 == 0){
            String protein = dna.substring(start, end+3);
            System.out.println("DNA SAMPLE: " + dna + " | LENGTH: " + length);
            System.out.println("PROTEIN FOUND: " + protein);
        }
        else{
            System.out.println("DNA SAMPLE: " + dna + " | LENGTH: " + length);
            System.out.println("NO PROTEIN FOUND!"); 
        }
    }
    public void dna3(){
        String dna = "ATTAATATGTACTGA";
        int length = dna.length();
        int start = dna.indexOf("ATG");
        int end = dna.indexOf("TGA");


        if (start != -1 && end != -1 && (start - end) % 3 == 0){
            String protein = dna.substring(start, end+3);
            System.out.println("DNA SAMPLE: " + dna + " | LENGTH: " + length);
            System.out.println("PROTEIN FOUND: " + protein);

        }
        else {
            System.out.println("DNA SAMPLE: " + dna + " | LENGTH: " + length);
            System.out.println("NO PROTEIN FOUND!");
        }
    
    }
    
    public void sampleLoop(){
        String[] sampleGroup = {"ATGCGATACGCTTGA", "ATGCGATACGTGA", "ATTAATATGTACTGA"};
        for (String sample : sampleGroup){
            int length = sample.length();
            int start = sample.indexOf("ATG");
            int end = sample.indexOf("TGA");
            if (start != -1 && end != -1 && (start - end) % 3 == 0){
                String protein = sample.substring(start, end+3);
                System.out.println("DNA SAMPLE: " + sample + " | LENGTH: " + length);
                System.out.println("PROTEIN FOUND: " + protein);
                System.out.println();
            }
            else {
                System.out.println("DNA SAMPLE: " + sample + " | LENGTH: " + length);
                System.out.println("NO PROTEIN FOUND!");
                System.out.println();
            }


        }
    }

    public static void main(String[] args){
        System.out.println("init test");
        LmnhDNA methodTester = new LmnhDNA();
        System.out.println();
        methodTester.dna1();
        System.out.println();
        methodTester.dna2();
        System.out.println();
        methodTester.dna3();
        System.out.println();
        methodTester.sampleLoop();
    }
}



// ATGCGATACGCTTGA
// ATGCGATACGTGA
// ATTAATATGTACTGA
