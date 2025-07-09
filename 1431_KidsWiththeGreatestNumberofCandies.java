import java.util.*;

class Solution 
{
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) 
    {
        // उत्तर साठवण्यासाठी Boolean प्रकाराची यादी तयार करा
        List<Boolean> list = new ArrayList<>();

        // सर्वात जास्त कँडी असलेल्या मुलाचा शोध घ्या
        int max = 0; // सुरुवातीला max ला 0 वर सेट करा

        // प्रत्येक मुलाकडे किती कँडी आहेत, हे तपासा आणि सर्वाधिक कँडी असलेल्या मुलाचा शोध घ्या
        for(int candy : candies) 
        {
            if (candy > max) // जर सध्याच्या मुलाकडील कँडी जास्त असतील, तर त्या max मध्ये साठवा
            {
                max = candy;
            }
        }

        // आता प्रत्येक मुलाच्या कँडींमध्ये `extraCandies` जोडून तपासा की तो मुलगा सर्वाधिक कँडी असलेल्या मुलाइतका होऊ शकतो का
        for(int candy : candies)
        {
            // जर (मुलाकडील कँडी + extraCandies) हे max च्या बरोबरी किंवा जास्त असेल, तर `true` जोडा
            list.add((candy + extraCandies) >= max);
        }

        // तयार केलेली यादी परत करा
        return list;
    }
}
