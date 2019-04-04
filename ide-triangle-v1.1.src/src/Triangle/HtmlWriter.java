package Triangle;

import Triangle.AbstractSyntaxTrees.Program;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;

public class HtmlWriter {

    private String fileName;
    private String nfileName;

    public HtmlWriter(String fileName,String nfileName) {
        this.fileName = fileName;
        this.nfileName = nfileName;
    }

    public String HtmlLineBuilder(String[] tokenList){
        String PrettyLine = "<p>";
        boolean commentFlag = false;
        String[] boldTokens = {"while", "then", "let", "var", "in", "end"};
        for (String token : tokenList) {
            if (Arrays.asList(boldTokens).contains(token)) {
                PrettyLine += "<span style=\"color: black; font-weight:bold\">" + token + "</span>" + " ";
            } else if (token.contains("!")) {
                PrettyLine += "<span style=\"color: green\">";
                PrettyLine += token + " ";
                commentFlag = true;
            } else {
                PrettyLine += token + " ";
            }
        }
        if(commentFlag){
            PrettyLine += "</span>";
        }
        PrettyLine += "</p>";
        return PrettyLine;
    }
    
    public void HtmlPrettyLine(FileWriter fileWriter, String fileName) throws FileNotFoundException, IOException {
        String line;
        try (
                InputStream fis = new FileInputStream(fileName);
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr);) {
            while ((line = br.readLine()) != null) {
                while ((line = br.readLine()) != null) {
                    String[] tokens = line.split(" ");
                    fileWriter.write(HtmlLineBuilder(tokens));
                    fileWriter.write("\n");
                }
            }
        }
    
    }
    
    public void write(Program ast) {
        // Prepare the file to write
        try {
            FileWriter fileWriter = new FileWriter(nfileName);

            //HTML header
            fileWriter.write("<!DOCTYPE html>");
            fileWriter.write('\n');
            fileWriter.write("<html>");
            fileWriter.write('\n');
            fileWriter.write("<head>");
            fileWriter.write('\n');
            //File title
            fileWriter.write("<title> Html representation</title>");
            fileWriter.write('\n');
            //File style
            fileWriter.write("<style>html *{\n" +
                             "   font-size: 1em !important;\n" +
                             "   color: #00008B;\n" +
                             "   font-family: Verdana !important;\n" +
                             "   }</style>");
            fileWriter.write('\n');
            fileWriter.write("</head>");
            fileWriter.write('\n');
            fileWriter.write("</body>");
            fileWriter.write('\n');
            HtmlPrettyLine(fileWriter,fileName);
            
            //closing
            fileWriter.write("</body>");
            fileWriter.write("</html>");
            fileWriter.close();
            System.out.println("Html file created succesfully.");

        } catch (IOException e) {
            System.err.println("Error while creating file for print the AST");
            e.printStackTrace();
        }
    }

}
