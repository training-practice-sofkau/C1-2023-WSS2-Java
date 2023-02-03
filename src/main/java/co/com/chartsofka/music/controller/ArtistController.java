package co.com.chartsofka.music.controller;

import co.com.chartsofka.music.dto.ArtistDTO;
import co.com.chartsofka.music.service.impl.ArtistServiceImpl;
import co.com.chartsofka.music.utils.Response;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;


@RestController
@RequestMapping("/charts")
public class ArtistController {

    private ArtistServiceImpl service;
    private Response response = new Response();
    private HttpStatus httpStatus;

    public ArtistController(ArtistServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/artists")
    public ResponseEntity<Response> getArtists(){
        response.restart();
        try {
            response.data = service.getArtists();
            httpStatus = HttpStatus.CREATED;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }


    @GetMapping("/artists/{type}")
    public ResponseEntity<Response> getArtistsByType(@PathVariable String type){
        response.restart();
        try {
            response.data = service.getArtistsByType(type);
            httpStatus = HttpStatus.CREATED;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }




    @PostMapping("/artists")
    public ResponseEntity<Response> createArtist(@RequestBody ArtistDTO artistDTO){
        response.restart();
        try {
            response.data = service.saveArtist(artistDTO);
            httpStatus = HttpStatus.CREATED;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @PutMapping("/artists/{artistID}")
    public ResponseEntity<Response> updateArtist(@RequestBody ArtistDTO artistDTO, @PathVariable String artistID){
        response.restart();
        try {
            response.data = service.updateArtist(artistDTO, artistID);
            httpStatus = HttpStatus.CREATED;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @DeleteMapping("/artists/{artistID}")
    public ResponseEntity<Response> deleteArtist(@PathVariable String artistID){
        response.restart();
        try {
            response.data = service.deleteArtist(artistID);
            httpStatus = HttpStatus.CREATED;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }



    /**
     * DataBase error handler
     * @param exception
     */
    private void getErrorMessageInternal(Exception exception) {
        response.error = true;
        response.message = exception.getMessage();
        response.data = exception.getCause();
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private void getErrorMessageForResponse(DataAccessException exception) {
        response.error = true;
        if(exception.getRootCause() instanceof SQLException) {
            SQLException sqlEx = (SQLException) exception.getRootCause();
            var sqlErrorCode = sqlEx.getErrorCode();
            switch (sqlErrorCode) {
                case 1062:
                    response.message = "El dato ya está registrado";
                    break;
                case 1452:
                    response.message = "El usuario indicado no existe";
                    break;
                default:
                    response.message = exception.getMessage();
                    response.data = exception.getCause();
            }
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            response.message = exception.getMessage();
            response.data = exception.getCause();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }


}
