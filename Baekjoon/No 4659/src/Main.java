import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String pw = br.readLine();
        String mo = "aeiou";


        while(!pw.equals("end")){
            boolean isOk = true;

            int cntMo = 0;
            for(int i=0; i<mo.length(); i++){
                if(pw.contains(String.valueOf(mo.charAt(i))))
                    cntMo++;
            }

            if(cntMo <= 0){
                bw.write("<" + pw + "> is not acceptable.\n");
                pw = br.readLine();
                continue;
            }

            boolean isMo = false;
            int cntConti = 1;
            if(mo.contains(String.valueOf(pw.charAt(0)))){
                isMo = true;
            }

            for(int i=1; i<pw.length(); i++){
                if(pw.charAt(i-1) == pw.charAt(i)
                    && pw.charAt(i)!='e' && pw.charAt(i)!='o'){
                    isOk = false;
                    continue;
                }

                if(mo.contains(String.valueOf(pw.charAt(i)))){
                    if(isMo){
                        cntConti++;
                    }else{
                        cntConti = 1;
                        isMo = true;
                    }
                }else{
                    if(!isMo){
                        cntConti++;
                    }else{
                        cntConti = 1;
                        isMo = false;
                    }
                }

                if (cntConti >= 3) {
                    isOk = false;
                }
            }

            if(isOk)
                bw.write("<" + pw + "> is acceptable.\n");
            else
                bw.write("<" + pw + "> is not acceptable.\n");
            pw = br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}