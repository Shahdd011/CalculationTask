package APP;

import ejbs.CalculationService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/calc")
public class CreateCalculation {

    @EJB
    private CalculationService calculationService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCalculation(CalculationRequest request) {
        try {
            int result = calculationService.performCalculation(request.getNumber1(), request.getNumber2(), request.getOperation());
            return Response.ok(new CalculationResponse(result)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
