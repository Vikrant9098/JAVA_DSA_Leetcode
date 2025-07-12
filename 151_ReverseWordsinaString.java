class Solution 
{
    public String reverseWords(String s) 
    {
        // स्टेप 1: स्ट्रिंग ट्रिम करा (सुरुवातीचे आणि शेवटचे spaces काढा)
        s = s.trim();

        // स्टेप 2: स्प्लिट करा आणि स्पेस हाताळा (एकापेक्षा जास्त spaces काढा)
        String[] str = s.split("\\s+");

        // स्टेप 3: शब्द उलट क्रमाने ठेवा
        StringBuilder result = new StringBuilder();

        for (int i = str.length - 1;  i >= 0; i--) 
        {
            result.append(str[i]); // शब्द जोडा
            
            if (i > 0) result.append(" "); // फक्त मधल्या शब्दांमध्ये space ठेवा
        }

        return result.toString(); // शेवटी reversed string परत करा
    }
}
