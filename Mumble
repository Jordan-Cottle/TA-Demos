public class Mumble {

    private static String repeatChars(char c, int count){
      StringBuilder str = new StringBuilder();
      
      for(int i = 0; i < count; i++){
        str.append(c);
      }
      
      return str.toString();
    }
    
    public static String accum(String s) {
    
       s = s.toLowerCase();
       StringBuilder str = new StringBuilder();
       
       for(int i = 0; i < s.length(); i++){
         char c = s.charAt(i);
         
         str.append((char)(c-32));
         
         str.append(repeatChars(c, i));
         
         str.append('-');
       }
       
       str.delete(str.length()-1, str.length());
       
       return str.toString();
    }
}
