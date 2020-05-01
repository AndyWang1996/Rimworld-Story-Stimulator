package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.*;

import fitness.Dice;

public class DataLoader {	 
	    /**
	     * 读取json文件
	     * @param fileName json文件名
	     * @return 返回json字符串
	     */
	    public static String readJsonFile(File jsonFile) {
	        String jsonStr = "";
	        try {
	            //File jsonFile = new File(fileName);
	            FileReader fileReader = new FileReader(jsonFile);
	            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
	            int ch = 0;
	            StringBuffer sb = new StringBuffer();
	            while ((ch = reader.read()) != -1) {
	                sb.append((char) ch);
	            }
	            fileReader.close();
	            reader.close();
	            jsonStr = sb.toString();
	            return jsonStr;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	    @SuppressWarnings({ "rawtypes", "unchecked" })
		public static void main(String args[]) {
	    	File file1 = new File("./data/humans/firstNames.json");
	    	File file2 = new File("./data/humans/lastNames.json");
	    	Map jsoMap1 = (Map) JSON.parse(readJsonFile(file1));
	    	Map jsoMap2 = (Map) JSON.parse(readJsonFile(file2));
	    	List<String> l1 = (List<String>) jsoMap1.get("firstNames");
	    	List<String> l2 = (List<String>) jsoMap2.get("lastNames");
	    	System.out.print(l1.get(Dice.throw_a_dice("1d" + l1.size())));
	    	System.out.print(l2.get(Dice.throw_a_dice("1d" + l2.size())));
	    }

}
