package com.example.android.silab;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by adrian on 13/06/15.
 * Helper class for silab project, creates list of emoji and character hashtable.
 */
public class SilabHelper {

    // This is an array of byte arrays. Each byte array can transformed into an emoji
    // the (byte) cast is needed because byte is unsigned in java... ugly ugly ugly
    private final byte[][] byteArray = {
            {(byte) 0xF0,(byte)0x9F,(byte)0x9A,(byte)0x95},
            {(byte) 0xF0,(byte)0x9F,(byte)0x9A,(byte)0x97},
            {(byte) 0xF0,(byte)0x9F,(byte)0x9A,(byte)0x99},
            {(byte) 0xF0,(byte)0x9F,(byte)0x8E,(byte)0x82},
            {(byte) 0xF0,(byte)0x9F,(byte)0x8E,(byte)0x89}
    };

    //This is a character array containing the useable characters
    //TODO add available characters here as they are finished
    private final char[] letters = {
            '!',
            ' ',
            'A',
            'B',
            'C',
            'H',
            'P',
            'Y',
            'I',
            'R',
            'T',
            'D',
            
    };

    //This is an ugly structure for containing character maps.
    //maps need to be in the order of the letters array above.
    private final int[][][] maps = {
            {
                    //!
                    {0,0,0,1,0,1,0,1,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0},
                    {0,0,0,0,1,0,1,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0},
                    {},
                    {0,0,0,0,0,1,0,0,0,0,0}
            },
            {
                    //Space
                    {},
                    {}
            },
            {
                    //A
                    {0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,0,0,1,0,0,0,0,1},
                    {0,0,0,1,0,0,0,0,0,0,0,0,0,0,1},
                    {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,1,1,1,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}
            },

            {
                    //B
                    {1,1,1,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,1,1,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,1,1,1}
            },

            {
                    //C
                    {0,0,0,0,1,1,1},
                    {0,1,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1},
                    {1},
                    {1},
                    {0,1,0,0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,1,1,1}
            },
            {
                    //H
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,1,1,1,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}
            },
            {
                    //P
                    {1,1,1,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,1,1,1},
                    {1},
                    {1},
                    {1}
            },
            {
                    //Y
                    {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,1,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,0,0,1,0,0,0,1},
                    {0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,0,0,0,0,0,0,1}
            },
            {
                    //I
                    {0,0,0,0,0,1,1,1},
                    {0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,0,1,1,1}
            },
            {
                    //R
                    {1,1,1,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,1,1,1},
                    {1,0,0,0,0,0,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,1}
            },
            {
                    //T
                    {1,1,1,1,1},
                    {0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,0,0,0,0,0,0,1},
                    {0,0,0,0,0,0,0,0,0,0,1}
            },
            {
                    //D
                    {1,1,1},
                    {1,0,0,0,0,0,0,0,0,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1},
                    {1,1,1}
            }
    };

    //What will become the list of emoji
    private List<String> emojiList = new ArrayList<>();

    //What will become the structure linking characters to their maps
    private Hashtable<Character, int[][]> charMap = new Hashtable<>();

    //constructor for this helper class
    public SilabHelper(){
        //On construction the emoji list is populated from the byte array above,
        //the Character Map is constructed
        populateEmojiList();
        buildCharMap();
    }

    //function that creates emoji from byte arrays and adds them to list
    protected void populateEmojiList(){
        for(int m=0;m<byteArray.length;m++){
            try {
                emojiList.add(new String(byteArray[m], "UTF-8"));
            }catch(UnsupportedEncodingException e){
                e.printStackTrace(); //have to catch this error, don't actually know what it is
            }
        }
    }

    //function that builds the Hashtable linking characters to their maps
    protected void buildCharMap(){
        for(int m=0; m<letters.length; m++) {
            charMap.put(letters[m],maps[m]);
        }
    }

    //the function called by application to get the emoji list
    public List<String> getEmojiList() {
        return emojiList;
    }

    //the function called by application to get the character map
    public Hashtable<Character, int[][]> getCharMap(){
        return charMap;
    }

}
