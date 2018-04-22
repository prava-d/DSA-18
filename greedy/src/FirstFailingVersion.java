public class FirstFailingVersion {

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {
        // TODO
        return fBVhelper(0, n, isBadVersion);
    }

    public static long fBVhelper(long start, long end, IsFailingVersion isBadVersion) {

        long bad;

        if (end - start < 0) {
            if (isBadVersion.isFailingVersion(start)) {
                return start;
            }
            else {
                return end;
            }
        }

        long mid = (start + end)/2;

        if (isBadVersion.isFailingVersion(mid)) {
            if (isBadVersion.isFailingVersion((mid - 1))) {
                bad = fBVhelper(start, mid - 1, isBadVersion);
            }
            else {
                return mid;
            }
        }
        else {
            bad = fBVhelper(mid + 1, end, isBadVersion);
        }

        return bad;

    }
}
