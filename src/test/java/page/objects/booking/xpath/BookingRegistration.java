
package page.objects.booking.xpath;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookingRegistration {
    //public final Clicker clicker = new Clicker();
    private static final Logger LOGGER = LogManager.getLogger(BookingHomePageXpath.class);
    public static final String BOOKING_SIGN_IN_PAGE = "https://account.booking.com/sign-in?op_token=EgVvYXV0aCKqBQoUdk8xS2Jsazd4WDl0VW4yY3BaTFMSCWF1dGhvcml6ZRo1aHR0cHM6Ly9zZWN1cmUuYm9va2luZy5jb20vbG9naW4uaHRtbD9vcD1vYXV0aF9yZXR1cm4qyQRVcGNEenFGWkdzakRRMTJHVlZRLXJoMDhIdnJ3Tk5GRkFHRUxZSExqbnFBRHIxaGpoY0RIZXBZXzNTVFUwWDc3T2NmaDJ5UmhjdzVSM2lBTHBlQjZtUGh1VkVZcXRnSFdBLUNON1ZwWlh2a3Y0YlpTdk5wOVNJVWJhX0VrYWhlZHdkXzk5VUR0Q0tqRmo4ZmhpZFV4cmdKWFdSX25na2lrc3hRM29ndkhjWGltTHNUQjFRMmx0UkFvcHNoRTVvRVhrRjdCelo2eWRYbHB2OGh1X3NoWkVudnFnUXFnRUZwNnYwZzk1a3dPMGszTEljNEVqeFl1SDNib1oteFQzQlRVVUNfZ2VBQ1hUN2VGY2lZclNWQUtfWUxhaVpoR3A3elNCRUd1Y21LRVhzNWN1X1ZCYUtxSVhCaGlGX0htY3FWMWxIbmtuN3JFeGFBb1c0QzNkWmZIdlppN2RDbE9Gb1FZbnBaOGRCQTduZEo0VlhCUklVWWpmTU9abTNQWktlVk85NzVUVGRqQktLb2dOaEdJWnVhcjV5TUx1QXltWXEzZEJjYmNGeDBnS1lTT0MzWEVMU1Bici1McXF5YkNiUnZDRWpfeVdPTGZLNHFhamlJNTc4ckNhTlV1TkhJQXdrSFhnMHV3bFYyRWJ5d2d3Y0tvaUlJUUF1a1IyVXo3MDdMSU40WE1jWVNhWFVyRUhqRmxwXzd6bG50NWExTlVCUFZmSm5vPSpleUpwWkNJNkluUnlZWFpsYkd4bGNsOW9aV0ZrWlhJaWZRPT1CBGNvZGUqMQiOyBIw05Hbmu79JjoAQgBY8pC_sQaSARB0cmF2ZWxsZXJfaGVhZGVymgEFaW5kZXg";
    public String signInButtonXpath = "//a[@data-testid='header-sign-in-button']";
    public static String signInEmailField = "//input[@type='email']";
    public static String signInPwdlField = "//input[@type='password']";
    public static String passWithEmailButtonXpath = "//button[@type='submit']/span[contains(text(), \"Продолжить через электронную почту\")]";

}
