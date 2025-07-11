class Solution {
    public String reverseVowels(String s) 
    {
        // सर्व स्वर (vowels) स्टोअर करण्यासाठी एक सेट तयार करा
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 
                                                             'A', 'E', 'I', 'O', 'U'));

        char[] arr = s.toCharArray(); // दिलेली स्ट्रिंग कॅरेक्टर ऍरेमध्ये रूपांतरित करा

        int left = 0, right = arr.length - 1; // दोन पॉइंटर्स, सुरुवातीला आणि शेवटी

        while (left < right) 
        {  
            // जोपर्यंत left < right आहे तोपर्यंत प्रक्रिया करा
            // डावीकडून स्वर शोधा
            while (left < right && !vowels.contains(arr[left])) 
            {
                left++; // जर left कॅरेक्टर स्वर नसेल, तर पुढे जा
            }

            // उजवीकडून स्वर शोधा
            while (left < right && !vowels.contains(arr[right])) 
            {
                right--; // जर right कॅरेक्टर स्वर नसेल, तर मागे जा
            }

            // जर दोन्ही स्वर सापडले असतील तर त्यांची देवाण-घेवाण करा (swap)
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // पुढे आणि मागे पॉइंटर्स हलवा
            left++;
            right--;
        }

        return new String(arr); // नवीन स्ट्रिंग परत करा
    }
}
