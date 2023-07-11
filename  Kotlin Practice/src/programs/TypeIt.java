package programs;

public class TypeIt {
    public static void main(String[] args) {
        System.out.println(minOperation("abcabca"));
        System.out.println(minOperation("abcdefgh"));
        System.out.println(minOperation("jklfjklfjklfjklfr"));
        System.out.println(minOperation("rsvtrsvtz"));
       /* String s = "abcabc";
        System.out.println(s.substring(3,6));*/
    }

    static int minOperation(String s) {
        char firstChar = s.charAt(0);
        int stringLength = s.length();
        int maxSteps = 0;
        for(int i=0;i<stringLength;i++){
           if(s.charAt(i) == firstChar){
               String stringFormedSoFar = s.substring(0,i);
               if((stringLength >= 2*i) && stringFormedSoFar.equals(s.substring(i,2*i))){
                   maxSteps = Math.max(i,maxSteps);
               }
           }
        }

        return maxSteps == 0 ? stringLength : stringLength - maxSteps + 1;
    }
}
