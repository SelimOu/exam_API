package com.exemple;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {
    private final TaskDAO dao = new TaskDAO();

    @GET
    public List<Task> getAll() {
        return dao.findAll();
    }

    @GET
    @Path("/{id}")
    public Task getById(@PathParam("id") Long id) {
        return dao.findById(id);
    }

    @POST
    public Task create(Task task) {
        dao.save(task);
        return task;
    }

    @PUT
    @Path("/{id}")
    public Task update(@PathParam("id") Long id, Task task) {
        task.setId(id);
        dao.update(task);
        return task;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        dao.delete(id);
    }
} 