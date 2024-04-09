package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.meeting.Meeting;
import seedu.address.model.person.Person;


/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_MULTIPLE_TAGS = "Please only input one tag";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "Error: The person index %1$s "
            + "provided is invalid!";
    public static final String MESSAGE_INVALID_FILTER_TAG = "Error: The tag %s provided does not belong to any client!";
    public static final String MESSAGE_RETURN_HOME = "If you wish to view another client please return home by "
            + "entering 'list' before viewing another client.";
    public static final String MESSAGE_INVALID_MEETING_DISPLAYED_INDEX = "Error: The meeting index %1$s " +
            "provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS = "Multiple values specified for "
            + "the following single-valued field(s): ";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields = Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        final StringBuilder builder = new StringBuilder();
        builder.append(person.getName())
                .append("; Phone: ")
                .append(person.getPhone())
                .append("; Email: ")
                .append(person.getEmail())
                .append("; Address: ")
                .append(person.getAddress())
                .append("; Tags: ");
        person.getTags().forEach(builder::append);
        return builder.toString();
    }
    /**
     * Formats the {@code meeting} for display to the user.
     */
    public static String format(Meeting meeting) {
        final StringBuilder builder = new StringBuilder();
        builder.append("Client: ")
                .append(meeting.getClientName())
                .append("DateTime: ")
                .append(meeting.getDateTime())
                .append("; Description: ")
                .append(meeting.getDescription());
        return builder.toString();
    }

    /**
     * Formats the {@code meeting} for display to the user.
     */
    public static String formatMeeting(Meeting meeting) {
        final StringBuilder builder = new StringBuilder();
        builder.append(meeting.getDescription())
                .append("; Date & Time: ")
                .append(meeting.getDateTime())
                .append("; Client: ")
                .append(meeting.getClientName());
        return builder.toString();
    }

}
