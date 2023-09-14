package api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToTable {
    public static void main(String[] args) {
        String json = "{\r\n"
        		+ "        \"permit_number\": \"202309126435\",\r\n"
        		+ "        \"permit_type\": \"8\",\r\n"
        		+ "        \"permit_type_definition\": \"otc alterations permit\",\r\n"
        		+ "        \"permit_creation_date\": \"2023-09-12T23:36:22.000\",\r\n"
        		+ "        \"block\": \"7083\",\r\n"
        		+ "        \"lot\": \"020\",\r\n"
        		+ "        \"street_number\": \"36\",\r\n"
        		+ "        \"street_name\": \"Monticello\",\r\n"
        		+ "        \"street_suffix\": \"St\",\r\n"
        		+ "        \"description\": \"re-roofing: remove and replace roofing material / existing roofing material (in-kind)\",\r\n"
        		+ "        \"status\": \"issued\",\r\n"
        		+ "        \"status_date\": \"2023-09-12T23:37:48.000\",\r\n"
        		+ "        \"filed_date\": \"2023-09-12T23:36:22.000\",\r\n"
        		+ "        \"issued_date\": \"2023-09-12T23:37:48.000\",\r\n"
        		+ "        \"estimated_cost\": \"8000\",\r\n"
        		+ "        \"revised_cost\": \"8000\",\r\n"
        		+ "        \"existing_use\": \"1 family dwelling\",\r\n"
        		+ "        \"proposed_use\": \"1 family dwelling\",\r\n"
        		+ "        \"plansets\": \"0\",\r\n"
        		+ "        \"existing_occupancy\": \"R-3\",\r\n"
        		+ "        \"proposed_occupancy\": \"R-3\",\r\n"
        		+ "        \"supervisor_district\": \"11\",\r\n"
        		+ "        \"last_permit_activity_date\": \"2023-09-12T23:36:23.000\",\r\n"
        		+ "        \"neighborhoods_analysis_boundaries\": \"Oceanview/Merced/Ingleside\",\r\n"
        		+ "        \"zipcode\": \"94132\",\r\n"
        		+ "        \"application_submission_method\": \"website\",\r\n"
        		+ "        \"location\": {\r\n"
        		+ "            \"type\": \"Point\",\r\n"
        		+ "            \"coordinates\": [\r\n"
        		+ "                -122.47043295,\r\n"
        		+ "                37.715704272\r\n"
        		+ "            ]\r\n"
        		+ "        },\r\n"
        		+ "        \"adu\": \"N\",\r\n"
        		+ "        \"record_id\": \"1678129220685\",\r\n"
        		+ "        \"primary_address_flag\": \"Y\",\r\n"
        		+ "        \"point_source\": \"parcel_centroid\",\r\n"
        		+ "        \"data_as_of\": \"2023-09-12T23:55:00.000\",\r\n"
        		+ "        \"data_loaded_at\": \"2023-09-13T04:15:56.000\"\r\n"
        		+ "    }";

        try {
            ObjectMapper obj = new ObjectMapper();
            JsonNode jsonNode = obj.readTree(json);

            // Assuming the JSON represents an object, you can iterate through its fields
            jsonNode.fields().forEachRemaining(entry -> {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

