package mx.gob.ivrea.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class ArchivoIO {

    /**
     * Metodo para obtener un archivo del classpath
     * 
     * @param nombreArchivo:
     *            El nombre del archivo a obtener sin extension
     * @param extension:
     *            la extension del archivo empezando con punto
     * @return un arreglo de bytes del archivo a obtener
     * @throws IOException
     *             si ocurre un problema que ocasione que no se pueda obtener el archivo
     */
    public byte[] obtenerArchivoDeClassPath(String nombreArchivo, String extension) throws IOException {

        StringBuilder nombre = new StringBuilder();
        nombre.append(nombreArchivo);
        if (extension != null && !extension.isEmpty()) {
            nombre.append(extension);
        }
        InputStream file = ClassLoader.getSystemResourceAsStream(nombre.toString());
        byte[] bytes = IOUtils.toByteArray(file);
        file.close();
        return bytes;
    }

    /**
     * Metodo para obtener un archivo del filesystem local
     * 
     * @param nombreArchivo:
     *            El nombre del archivo con extension o sin extension segun sea el caso
     * @param ruta:
     *            la ruta del archivo
     * @return un arreglo de bytes del archivo
     * @throws IOException
     *             si ocurre un problema que ocasione que no se pueda obtener el archivo
     */
    public byte[] obtenerArchivoDeFileSystem(String nombreArchivo, String ruta) throws IOException {

        if (ruta == null || nombreArchivo == null) {
            return new byte[1];
        } else {
            String separador = System.getProperty("file.separator");
            StringBuilder cadena = new StringBuilder();
            cadena.append(ruta);
            if (!ruta.endsWith(separador)) {
                cadena.append(separador);
            }
            cadena.append(nombreArchivo);

            FileInputStream in = new FileInputStream(new File(cadena.toString()));
            byte[] bytes = IOUtils.toByteArray(in);
            in.close();
            return bytes;
        }
    }

    public byte[] obtenerArchivoDeFileSystemRemoto() {

        return new byte[1];
    }
}
