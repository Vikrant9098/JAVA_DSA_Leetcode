class Solution {
    public int compress(char[] chars) 
    {
        int write = 0; // संकुचित (compressed) स्ट्रिंग लिहिण्यासाठी पॉइंटर
        int read = 0;  // मूळ अॅरे वाचण्यासाठी पॉइंटर

        while (read < chars.length) 
        { 
            // संपूर्ण अॅरे वर लूप चालवा
            char currentChar = chars[read]; // सध्याचा कॅरेक्टर घ्या
            int count = 0; // त्या कॅरेक्टरची मोजणी करण्यासाठी काउंटर

            // सध्याचा कॅरेक्टर किती वेळा सलग येतो ते मोजा
            while (read < chars.length && chars[read] == currentChar) 
            {
                read++; // पुढे जा
                count++; // मोजणी वाढवा
            }

            // त्या कॅरेक्टरला संकुचित अॅरेमध्ये लिहा
            chars[write++] = currentChar;

            // जर कॅरेक्टरचा **count > 1** असेल तर त्याची संख्या देखील लिहा
            if (count > 1) 
            {
                // कॅरेक्टरची संख्या स्ट्रिंगमध्ये रूपांतरित करा आणि त्याचे प्रत्येक अंक लिहा
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c; // त्या अंकाला अॅरेमध्ये ठेवा
                }
            }
        }

        return write; // संकुचित अॅरेची नवीन लांबी परत करा
    }
}
