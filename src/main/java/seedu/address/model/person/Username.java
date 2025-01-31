package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

//@@author madanalogy
/**
 * Represents a Person's username in the incident management system.
 * Guarantees: immutable; is valid as declared in {@link #isValidUsername(String)}
 */
public class Username {

    public static final String MESSAGE_CONSTRAINTS = "Usernames must adhere to the following requirements: \n"
            + "1. Usernames must be at least 3 characters in length\n"
            + "2. Usernames can only consist of alphanumeric characters and the following special characters,"
            + "excluding the parentheses, (.-)\n"
            + "3. Usernames cannot begin or end with a non alphanumeric character\n"
            + "4. Usernames cannot be blank or contain a whitespace";

    /*
     * The first character of the username must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[a-zA-Z0-9][a-zA-Z0-9.-]+[a-zA-Z0-9]";

    public final String value;

    /**
     * Constructs a {@code Username}.
     *
     * @param username A valid name.
     */
    public Username(String username) {
        requireNonNull(username);
        checkArgument(isValidUsername(username), MESSAGE_CONSTRAINTS);
        this.value = username;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidUsername(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Username // instanceof handles nulls
                && value.equalsIgnoreCase(((Username) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
