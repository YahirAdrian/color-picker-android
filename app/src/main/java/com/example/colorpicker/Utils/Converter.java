package com.example.colorpicker.Utils;

public class Converter {

    public static String rgb_to_hex(int red_value, int green_value, int blue_value)
    {
        String [] values ={"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" , "A", "B", "C", "D", "E", "F"};
        String hex;

        String firstDigit = values[(int) red_value/16];
        String seconDigit = values[(int) red_value%16];
        String thirdDigit = values[(int) green_value / 16];
        String fourthDigit = values[(int) green_value%16];
        String fivethDigit = values[(int) blue_value/16];
        String sixthDigit = values[(int) blue_value%16];


        hex = "Hex: #" + firstDigit + seconDigit + thirdDigit + fourthDigit + fivethDigit + sixthDigit;
        return hex;
    }

    public static String rgb_to_cmyk(double red, double green, double blue)
    {
        red/=255;
        green/=255;
        blue/=255;
        double key = 1-max_value(red, green, blue);
        int cyan, magenta, yellow;
        cyan = (int) Math.round(((1-red-key)/(1-key))*100);
        magenta =(int) Math.round(((1-green-key)/(1-key))*100);
        yellow = (int) Math.round(((1-blue-key)/(1-key))*100);

        int finalkey =(int) Math.round(key*100);
        String cmyk = "cmyk(" + cyan + "%," + magenta + "%," + yellow + "%," + finalkey + "%)";

        return cmyk;
        /*
        //SACAMOS LO VALORE PRIMAS PARA SACAR EL KEY
        double pred = red_value/255;
        double pgreen = green_value/255;
        double pblue = blue_value/255;

        //SACAMOS EL KEY CON EL VALOR MAXIMO DE LAS TRES PRIMAS
        double pkey=1-max_value(pred, pgreen, pblue);

        double cyan, magenta, yellow, key;
        cyan =  ((1-pred-pkey)/(1-pkey));
        magenta = ((1-pgreen-pkey)/(1-pkey));
        yellow =  ((1-pblue-pkey)/(1-pkey));


        String cmyk = "cmyk(" + cyan + "%," + magenta + "%," + yellow + "%," + pkey + "%)";
        return cmyk;*/
    }

    public static double max_value(double n1, double n2, double n3)
    {
        if(n1>n2)
        {
            if (n1>n3)
            {
                return n1;
            }else{
                return n3;
            }
        }else if(n2 > n3){
            return n2;
        }else{
            return n3;
        }
    }
}
