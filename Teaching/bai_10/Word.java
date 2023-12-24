public class Word {
    private String content;
    private int numWords;
    public Word() {
    }
    public Word(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getNumWords() {
        return numWords;
    }
    public void setNumWords() {
        int count = 0;
        String arr[] = this.content.split("");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(" ")) {
                continue;                
            }
            count++;
        }
        this.numWords = count;
    }

    public void countADigit() {
        int count = 0;
        String arr[] = this.content.split(""); 
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toUpperCase().equals("A")) {
                count++;           
            }
        }
        System.out.println("Co tong cong "+ count + " chu A");
    }

    public void standardization() {
        String arr[] = this.content.split(""); 
        String result = "";
        String temp = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(" ") && (temp.equals(" ") || temp.equals(""))) {
                continue;
            }
            if (temp.equals(" ") || temp.equals("")) {
                result = result + arr[i].toUpperCase();
                temp = arr[i];
                continue;
            }
            result = result + arr[i].toLowerCase();
            temp = arr[i];
        }
        this.content = result;
    }

    @Override
    public String toString() {
        return "Word [content=" + content + ", numWords=" + numWords + "]";
    }

    public static void main(String[] args) {
        Word word = new Word("   aBcD     abcD   ");
        word.standardization();
        word.countADigit();
        word.setNumWords();
        System.out.println("Co tong cong " + word.getNumWords() + " ky tu");
        System.out.println(word.getContent());
    }
    
}
