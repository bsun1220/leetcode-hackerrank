public class String_Compression {

    public int compress(char[] chars) {

        if(chars.length == 1)
        {
            return 1;
        }

        StringBuilder s = new StringBuilder("");

        int count = 1;
        char begin = chars[0];

        for(int i = 1; i < chars.length; i++)
        {

            if (chars[i] != begin)
            {
                s.append(begin);
                if(count != 1)
                {
                    s.append(count);
                }
                if(i == chars.length - 1)
                {
                    s.append(chars[i]);
                }

                begin = chars[i];
                count = 0;
            }
            if((i == chars.length - 1) && count != 0)
            {
                s.append(begin);
                s.append(count+1);
            }
            count++;
        }

        char[] ret = s.toString().toCharArray();
        for(int i = 0; i < ret.length; i++)
        {
            chars[i] = ret[i];
        }
        for(int i = ret.length; i < chars.length; i++)
        {
            chars[i] = ' ';
        }
        return ret.length;
    }
}
