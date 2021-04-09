package com.abcompany.view.pdf;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.abcompany.model.Clase;
import com.abcompany.model.Estudiante;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("clase")
public class ClasePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Clase clase = (Clase) model.get("clase");
		
		PdfPTable tabla = new PdfPTable(1);
		tabla.setSpacingAfter(20);
		
		PdfPCell cell = null;
		
		cell = new PdfPCell(new Phrase("Datos de la clase"));
		cell.setBackgroundColor(new Color(85,159,234));
		cell.setPadding(8f);
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(cell);
		
		tabla.addCell("Nombre: " + clase.getNombre());
		tabla.addCell("Profesor: "+ clase.getProfesor().getNombre()+" "+clase.getProfesor().getApellidos());
		tabla.addCell("Grado: "+clase.getGrado().getNombre());
		tabla.addCell("Número de estudiantes: "+clase.getEstudianteList().size());
		PdfPTable tabla2 = new PdfPTable(1);
		
		cell = new PdfPCell(new Phrase("Lista de estudiantes"));
		cell.setBackgroundColor(new Color(95,245,127));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		cell.setPadding(8f);
		
		tabla2.addCell(cell);
		
		document.add(tabla);
		document.add(tabla2);
		
		PdfPTable tabla3 = new PdfPTable(5);
		tabla3.setWidths(new float[] {2.5f,1,1,1,1});
		tabla3.addCell("Estudiante");
		tabla3.addCell("Positivo");
		tabla3.addCell("Negativo");
		tabla3.addCell("Puntos total");
		tabla3.addCell("Cantidad de premios");
		
		for(Estudiante estudiante: clase.getEstudianteList()) {
			tabla3.addCell(estudiante.getNombre()+" "+ estudiante.getApellido());
			
			cell = new PdfPCell(new Phrase(estudiante.getPuntosFavor().toString()));
			cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			tabla3.addCell(cell);
			
			cell = new PdfPCell(new Phrase(estudiante.getPuntosContra().toString()));
			cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			tabla3.addCell(cell);
			
			cell = new PdfPCell(new Phrase(estudiante.getPuntosTotal().toString()));
			cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			tabla3.addCell(cell);
			
			cell = new PdfPCell(new Phrase(""+estudiante.getPremioList().size()));
			cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			tabla3.addCell(cell);

		}
		
		
		
		document.add(tabla3);
	}


	
	
}