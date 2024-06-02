package com.gigantic.admin.Config.Export;

import com.gigantic.entity.User;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserCSVExporter extends AbstractExporter {

    public void export(List<User> listUsers, HttpServletResponse response) throws IOException {
        super.setResponseHeader(response, "text/csv", ".csv", "users_");

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        // Add a title row
        csvWriter.writeComment("List of Users");

        // Add a blank line for separation
        csvWriter.writeComment("");

        // Set CSV headers
        String[] csvHeader = {"User ID", "E-mail", "First Name", "Last Name", "Roles", "Enabled"};
        String[] fieldMapping = {"id", "email", "firstName", "lastName", "roles", "enabled"};

        csvWriter.writeHeader(csvHeader);

        // Write data rows
        for (User user : listUsers) {
            csvWriter.write(user, fieldMapping);
        }

        // Add a footer row
        csvWriter.writeComment("");
        csvWriter.writeComment("End of User List");

        csvWriter.close();
    }
}
