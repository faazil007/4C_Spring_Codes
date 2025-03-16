import java.io.*;

public class File_Handler
{
    private String path;
    private boolean append;
    public File_Handler(String path)
    {
        this.path=path;
        append=false;
    }
    public File_Handler(String path,boolean append)
    {
        this.path=path;
        this.append=append;
    }
    public  void writeData(String data) throws IOException
    {
        FileWriter writer=new FileWriter(path,append);
        writer.write(data);
        writer.close();

    }
    public String readData() throws IOException
    {
        String filedata="";
        FileReader reader=new FileReader(path);
        int ascii;
        while ((ascii=reader.read())!=-1)
        {
            filedata=filedata + (char)ascii;

        }
        return  filedata;
    }
}
