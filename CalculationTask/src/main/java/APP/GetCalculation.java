package APP;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
public class GetCalculation {

    private static List<Calculation> calculations = new ArrayList<>(); // List to store calculations

    @POST
    @Path("/calc")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCalculation(Calculation calculation) {
        calculations.add(calculation); // Add calculation to the list
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/calculations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCalculations() {
        return Response.status(Response.Status.OK).entity(calculations).build();
    }
}
