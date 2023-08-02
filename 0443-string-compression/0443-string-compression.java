class Solution {
    public int compress(char[] chars) {
              int count=1, i=0, j=1, index=0;
        while(j<chars.length && i!=j){
            if (chars[i]!=chars[j]){
                i++;
                j++;
                continue;
            }
            while (chars[i]==chars[j]){
                count++;
                chars[j]='\0';
                if(j==chars.length-1){
                    break;
                }j++;
            }
            if (count>9 && count<100){
                chars[i+1]=(char)(count/10 + '0');
                chars[i+2]=(char)(count%10 + '0');
            }
            else if (count>99 && count<1000){
                chars[i+1]=(char)(count/100 + '0');
                chars[i+2]=(char)(count%100 + '0');
                chars[i+3]=(char)(count%100 + '0');
            }
            else if (count>999){
                chars[i+1]=(char)(count/1000 + '0');
                chars[i+2]=(char)(count%10 + '0');
                chars[i+3]=(char)(count%10 + '0');
                chars[i+4]=(char)(count%10 + '0');
            }
            else {
                chars[i+1]=(char)(count + '0');
            }
            i=j;
            j++;
            count=1;
        }
        int k=0;
        while(k<chars.length-1){
            if (chars[k] == '\0' && chars[k + 1] != '\0') {
                int temp=chars[k];
                chars[k]=chars[k+1];
                chars[k+1]=(char)temp;
                k--;
                continue;
            }
            k++;
        }
        for(char ch: chars){
            if(ch=='\0') continue;
            index++;
        }
       return index;
    }
}