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

}
