
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;

class RemoveFriends {
    public static void main(String args[]) throws Exception {

        Print print = new Print();
        Scan s = new Scan();
        int t = s.scanInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = s.scanInt();
            int k = s.scanInt();
            List<Integer> friend = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                friend.add(s.scanInt());

            }
            //k is the number of friends he want to remove
            int count = 0;
            // while(count!=k){
            //     //Keep on deleting until count reaches k
            //     //
            deleteFriend(friend, k, count);
            // count++;
            //  }
            for (int i = 0; i < friend.size(); i++) {
                sb.append(friend.get(i) + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());

    }

    public static void deleteFriend(List<Integer> friend, int k, int count) {

        boolean delFrd = false;

        for (int i = 0; i < friend.size() - 1; i++) {
            if (friend.get(i) < friend.get(i + 1)) {
                //Delete ith Friend
                count++;
                i=friend.indexOf(friend.get(i))-1;
                friend.remove(i);
                System.out.print(i);
                //Again set the i to i-1
                //i=i-1;
                // delFrd=true;
                // break;
                if (k == count) {
                    delFrd = true;

                    break;

                }

            }
        }
        // System.out.print(friend);
        if (delFrd == false) {
            //Means remove the last k elements
            int ele = k - count;//ele elements will be removed from the last index
            int ele_count = 0;
            while (ele_count != ele) {
                friend.remove(friend.size() - 1);
                ele_count++;
            }
            friend.remove(friend.size() - 1);
            //remove the last friend here
        }

    }
}

class Scan {
    private byte[] buf = new byte[1024];
    private int index;
    private InputStream in;
    private int total;

    public Scan() {
        in = System.in;
    }

    public int scan() throws IOException {
        if (total < 0) {
            throw new InputMismatchException();
        }
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }

    public int scanInt() throws IOException {
        int integer = 0;
        int n = scan();
        while (isWhiteSpace(n)) {
            n = scan();
        }
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = scan();
            } else
                throw new InputMismatchException();
        }
        return neg * integer;
    }

    public long scanLong() throws IOException {
        long integer = 0;
        int n = scan();
        while (isWhiteSpace(n)) {
            n = scan();
        }
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = scan();
            } else
                throw new InputMismatchException();
        }
        return neg * integer;
    }

    public double scanDouble() throws IOException {
        double doub = 0;
        int n = scan();
        while (isWhiteSpace(n))
            n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n) && n != '.') {
            if (n >= '0' && n <= '9') {
                doub *= 10;
                doub += n - '0';
                n = scan();
            } else
                throw new InputMismatchException();
        }
        if (n == '.') {
            n = scan();
            double temp = 1;
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    temp /= 10;
                    doub += (n - '0') * temp;
                    n = scan();
                } else
                    throw new InputMismatchException();
            }
        }
        return doub * neg;
    }

    public String scanString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = scan();
        while (isWhiteSpace(n)) {
            n = scan();
        }
        while (!isWhiteSpace(n)) {
            sb.append((char) n);
            n = scan();
        }
        return sb.toString();
    }

    public byte[] scanBytes(int N) throws IOException {
        byte[] bytes = new byte[N];
        int diff = total - index;
        int i = index;
        for (; i < total && i - index < N; i++) {
            bytes[i - index] = buf[i];
        }
        index = i;
        if (diff >= N) {
            return bytes;
        }
        in.read(bytes, diff, N - diff);
        return bytes;
    }

    public boolean scanBoolean() throws IOException {
        int integer = 0;
        int n = scan();
        while (isWhiteSpace(n)) {
            n = scan();
        }
        return n == '1';
    }

    private boolean isWhiteSpace(int n) {
        if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) {
            return true;
        }
        return false;
    }
}

class Print {
    private final BufferedWriter bw;

    public Print() {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void print(String str) throws IOException {
        bw.append(str);
    }

    public void printLine(String str) throws IOException {
        print(str);
        bw.append("\n");
    }

    public void close() throws IOException {
        bw.close();
    }
}