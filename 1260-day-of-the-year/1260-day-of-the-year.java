class Solution {
    public int dayOfYear(String date) {
         int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        // Check for leap year and if the date is after February
        if (month > 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            day += 1; // Add one day for leap year
        }

        // Use a for loop to add up the days of the months before the given month
        for (int i = 0; i < month - 1; i++) {
            day += days[i];
        }

        return day;
    }
}