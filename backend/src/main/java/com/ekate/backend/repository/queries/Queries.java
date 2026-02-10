package com.ekate.backend.repository.queries;

public class Queries {
    public static final String createOrganisationQuery
            = "INSERT INTO organization(uuid,organization_name,setup_complete) values (?,?,?)";
    public static final String createUnit
            = "with get_organisation_name as(\n" +
            "\tselect uuid from organization\n" +
            "\twhere organization_name  = ?\n" +
            ")\n" +
            "insert into unit (uuid,unit_name,organization_id ) values (?,?,(select a.uuid from get_organisation_name a))";

    public static final String getByEmail = "select e.*, u.\"unit_name\" from employee e\n" +
            "left join unit u  on e.unit_id = u.uuid\n" +
            "where email = ?\n";
    public static final String createEmployee =
            "with get_unit_id as(\n" +
                    " select uuid from unit   \n" +
                    " where unit_name = ?\n" +
                    ")\n" +
                    "INSERT INTO employee(uuid,name,second_name,patronymic,password,email,unit_id) " +
                    "values(?,?,?,?,?,?,(select u.uuid from get_unit_id u))";

}
