import java.util.*;

public class Main {
    //------------------------------------TASK 1----------------------------
    /*
     * Rogor mushaobs:
     * Igebs ciprebs da kmnis ricxvs(num), manam sanam ar ipovis
     * raime operacias, bolo operacia sruldeba ciklis garet. Tavidan op='z',
     * pirdapir vwer num-s result-shi, shemdgomshi ki result-shi vamateb/vakleb num-s;
     *
     * Isvris exception-s tu ki operacia gansxvavdeba + da - gan
     *
     * Viyeneb:evaluateExpressionHelper funkcias kodis shemcirebistvis da uket designistvis
     */
    static public int evaluateExpression(String expression){
        int num = 0, result = 0;
        char op='z';

        for(int i = 0; i<expression.length();i++){
            char currChar = expression.charAt(i);

            if(Character.isDigit(currChar)){
                num=num*10+Character.getNumericValue(currChar);
            }else{
                result = evaluateExpressionHelper(op, num, result);
                num=0;
                op=currChar;
            }
        }

        result = evaluateExpressionHelper(op, num, result);

        return result;
    }

    private static int evaluateExpressionHelper(char op, int num, int result){
        if(op=='+'){
            result += num;
        }else if(op=='-'){
            result -= num;
        }else if(op=='z'){
            result = num;
        }else{
            throw new IllegalArgumentException();
        }
        return result;
    }
    //------------------------------------TASK 1 END----------------------------

    //------------------------------------TASK 2----------------------------------
    /*
     * Rogor mushaobs: makvs cikli ciklsi. Gare cikli garbis listshi, xolo
     * shida tito stringze. Shida cikls viwyeb pirveli indeksis mkone elementidan da vadareb winas,
     * tu ki asoebi daemtxva gavdivar ciklidan. Akve, davidanve counter udris listis zomas,
     * shemdgomshi arabednieri stringebis povnisas prosta  vakleb, upro martivia.
     */
    static int numberOfHappyStrings(List<String> strings){
        int counter=strings.size();

        for(int i = 0; i<strings.size();i++){
            String currString = strings.get(i);

            for(int j = 1;j<currString.length();j++){
                if(currString.charAt(j)==currString.charAt(j-1)){
                    counter--;
                    break;
                }
            }
        }

        return counter;
    }

    //------------------------------------TASK 2 END----------------------------------

    //------------------------------------TASK 3--------------------------------------
    /*
     * Rogor mushaobs: gadavdivar yovel shemdeg node-ze, vinaxav shemdegis shemdegs,
     * vanadgureb kavshirs shemdegis shemdegtan, vakavshireb winastan da ase shemdeg,
     * sanam ar mivalt node-amde romlis shemdegi null tolia.
     * Warmodgenstvis: isrebs vucvli mimartulebas(isari, anu kavshiri).
     *
     * Aseve sheknili makvs primitiuli ListNode class-i da printListNode function bechdvistvis.
     */
    static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val, ListNode next){
            this.val=val;
            this.next = next;
        }
        public void print(){
            System.out.print(val);
        }
    }

    static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        return prev;
    }

    static void printListNode(ListNode head){
        head.print();
        while(head.next!=null){
            head=head.next;
            System.out.print(" -> ");
            head.print();
        }
    }

    //------------------------------------TASK 3 END----------------------------------

    //------------------------------------TASK 4--------------------------------------
    /*
     * Yvelaze martivi gza: vkmni set<Integer>-s,
     * vushveb cikl ciklshi, gairbens yvela elementebs, tuki
     * nums1[i]==nums2[j] vamateb set-shi(ikneba unikaluri).
     *
     * Shemdeg ki stream-is daxmarebit Set->int[] an
     * xelit, vushveb cikls da iteratoris daxmarebit gavirben
     * set-shi, tito elements vamateb shekmnil massivshi(masivis_sigrdze=set_sigrdzes)
     */
    static int[] findIntersection(int[] nums1, int[] nums2){
        Set<Integer> intersection = new HashSet<>();

        for(int i = 0; i<nums1.length;i++){
            for(int j = 0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    intersection.add(nums1[i]);
                }
            }
        }

        int[] arr = new int[intersection.size()];

        int index=0;
        for(int curr:intersection){
            arr[index++]=curr;
        }

        return arr;
    }
    //------------------------------------TASK 4 END----------------------------------

    //------------------------------------TASK 5--------------------------------------
    /*
     * Rogor mushaobs: jer vsortav xelit bubble sortis xmarebit. Elementebi iknebian dalagebuli
     * zrdadobit. Shemdeg ki vushveb cikls da vzrdi elementebis raodenobas manam sanam ar mivagweb
     * k-s mnishvnelobas.
     */
    static int lenOfLongSubarr(int[] array, int k){
        int counter = 0;
        int sum = 0;

        // bubble sort
        int size = array.length;
        for(int i = 0; i<size-1;i++){
            for(int j = 0;j<size-i-1;j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }

        for(int i =0;i<size;i++){
            if(sum+array[i]<=k){
                sum+=array[i];
                counter++;
            }
        }

        return counter;
    }
    //------------------------------------TASK 5 END----------------------------------

    //------------------------------------TASK 6--------------------------------------
    /*
     * Rogor mushaobs: gare ciklshi garbis sequece-shi, shidashi ki array-ashi.
     * Tuki daemtxva, acherebs shida cikls da gadadis gares shemdeg elementze.
     * Amavdroulad inaxavs damtxvevis shida index, shemdeg iteraciaze mandedan
     * rom gaagrdzelos. Tuki movida bolomde da cikli ar shecherebula -> es imas
     * nishnavs rom ar ipova msgavsi elementi array-shi, anu return false.
     */
    static boolean isValidSequence(int[] array, int[] sequence){
        for(int i = 0, jstart = 0;i<sequence.length;i++){
            for(int j = jstart;j<array.length;j++){
                if(sequence[i]==array[j]){
                    jstart = j;
                    break;
                }
                if(j==array.length-1){
                    return false;
                }
            }
        }
        return true;
    }
    //------------------------------------TASK 6 END----------------------------------

    // viyeneb magaliteb .docx failidan
    public static void main(String[] args) {
        // Task 1
        String expression = "5+20-8+5";
        System.out.println("Task 1: result = " + evaluateExpression(expression));

        //Task 2
        List<String> strings = Arrays.asList("abbccv", "abc", "abcabc", "cabcbb");
        System.out.println("Task 2: result = " + numberOfHappyStrings(strings));

        //Task 3
        // node-bis shekmna
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        // bechdva
        System.out.print("Task 3: before the reverse\t");
        printListNode(head);

        ListNode newHead = reverseList(head);

        System.out.print("\n\t\tafter the reverse\t");
        printListNode(newHead);

        //Task 4
        int[] nums1 = {1,2,3,3,4,5};
        int[] nums2 = {3,4,4,5,6,7};

        int[] result = findIntersection(nums1, nums2);

        System.out.print("\nTask 4: result = ");
        for(int i = 0; i<result.length;i++){
            System.out.print(result[i]+" ");
        }

        //Task 5
        int[] array = {6,2,2,3,4,1};
        int k = 8;

        System.out.println("\nTask 5: result = " + lenOfLongSubarr(array, k));

        //Task 6
        int[] arr = {5,1,22,25,6,-1,8,10};
        int[] sequence = {1,6,-1,10};

        System.out.println("Task 6: result = " + isValidSequence(arr, sequence));
    }
}
