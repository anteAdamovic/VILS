package vils.network;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class HTMLObject {
    private String mTagName = "";
    private Map<String,String> mAttributes;
    private HTMLObject mParent;
    private List<HTMLObject> mChildren;

    public HTMLObject(String data){
      mParent = null;

      System.out.println(data);

      String tag = data.substring(1, data.indexOf(">"));
      mTagName = tag.substring(0, data.indexOf(" "));
      System.out.println(mTagName.startsWith("!"));
      System.out.println(mTagName.substring(1, mTagName.length()).equals("DOCTYPE"));
      if(mTagName.startsWith("!") && mTagName.substring(0, mTagName.length()).equalsIgnoreCase("doctype"))
        System.out.println("This is doctype");
      System.out.println("tagName: " + mTagName);

    }

    public HTMLObject(String data, HTMLObject parent){
      mParent = parent;
    }
}
