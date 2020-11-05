package com.neil.castellino.ivtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class FragmentMusic extends ListFragment {
    ArrayList<Music> musicArrayList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DownloadDataTask task = new DownloadDataTask();
        try {
            String result = "";
            result = task.execute("https://www.wits-interactive.com/ftp/test/music.xml").get();

            if(!result.equals("")) {
                // TO READ THE XML FILE
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(new InputSource(new StringReader(result)));

                Element element = doc.getDocumentElement();
                element.normalize();

                NodeList nList = doc.getElementsByTagName("itune");

                for (int i = 0; i < nList.getLength(); i++) {
                    Node node = nList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element innerElement = (Element) node;
                        Music music = new Music(
                                innerElement.getElementsByTagName("Title").item(0).getChildNodes().item(0).getNodeValue(),
                                innerElement.getElementsByTagName("Artist").item(0).getChildNodes().item(0).getNodeValue(),
                                innerElement.getElementsByTagName("ThumbURL").item(0).getChildNodes().item(0).getNodeValue());
                        musicArrayList.add(music);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_music_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapterMusic adapter = new ArrayAdapterMusic(getContext(),musicArrayList);
        setListAdapter(adapter);
    }
}
