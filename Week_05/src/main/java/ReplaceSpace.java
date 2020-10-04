public class ReplaceSpace {


    public String replaceSpace(String s) {

        int length = s.length();
        char[] array = new char[length*3];
        int size = 0;
        for(int i = 0; i<length;i++){
            if(s.charAt(i) == ' '){
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }
            else{
                array[size++] = s.charAt(i);
            }
        }
        return new String(array,0,size);
    }

    public static void main(String[] args){
        System.err.println(new ReplaceSpace().replaceSpace("We are happy."));
    }

}
