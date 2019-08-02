package com.github.liamsharp;

import static org.junit.Assert.fail;

import javax.xml.parsers.ParserConfigurationException;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.junit.Test;
import org.w3c.dom.Document;

public class AppTest 
{
    final String HTML = "<html>"
            + "<body>"
            + "<img srcset=\"<svg%20\">"
            + "</body>"
            + "</html>";
    final boolean ESCAPE_XML = false;
    
    @Test
    public void testApp()
    {
        final TagNode tagNode = new HtmlCleaner().clean(HTML);
        System.out.println(tagNode);
        final CleanerProperties cleanerProperties = new CleanerProperties();
        System.out.println(cleanerProperties);
        try
        {
            final Document doc = new DomSerializer(cleanerProperties, false).createDOM(tagNode);
            System.out.println(doc);
        }
        catch (ParserConfigurationException e)
        {
            fail(e.toString());
        }
    }
}
