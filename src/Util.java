import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Util {
    static String lokasiFileInput ="/input.md";
    static String lokasiFileOutput ="/output.md";
    static ArrayList<Long> inputSisi = new ArrayList<Long>();
    //windows  C:\\
    public static void init(){
        try {
            
           String lokasi = new File(".").getCanonicalPath();
           lokasiFileInput = lokasi + lokasiFileInput;
           lokasiFileOutput = lokasi + lokasiFileOutput;
           System.out.println(lokasi);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
    public static void bacaFile(){
        String data;
        FileReader fin =null;
        try {
            fin = new FileReader(lokasiFileInput);
            BufferedReader br = new BufferedReader(fin);
            do{
                data= br.readLine();
                if(data!=null)   {
                    System.out.println(data);
                    inputSisi.add(Long.parseLong(data));
                }
            }while(data!=null);
        }catch(FileNotFoundException e){
            System.out.println("File tidak ditemukan! coba periksa kembali "+lokasiFileInput);
        }catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }finally{
            try {
                
            fin.close();
            } catch (Exception e) {
                //TODO: handle exception
               System.out.println(e.getMessage());
            }
        }
    }

    public static void tulisFile(){
        String data ="ini adalah yang akan disimpan";
        FileWriter fw=null;
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
           fw = new FileWriter(lokasiFileOutput);
           for (Long sisi : inputSisi) {
              Long volume =   sisi *sisi *sisi;
              fw.write(volume + "\n");
           }
        }catch(FileNotFoundException e){
            System.out.println("File tidak ditemukan! coba periksa kembali "+lokasiFileOutput);
        } 
        catch (Exception e) {
            //TODO: handle exception
               System.out.println(e.getMessage());
        }finally{
            try {
                fw.close();
            } catch (Exception e) {
                //TODO: handle exception
               System.out.println(e.getMessage());
            }
        }
    }



}
