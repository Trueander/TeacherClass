package com.abcompany.view.pdf;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.abcompany.model.Clase;
import com.abcompany.model.Estudiante;
import com.abcompany.model.Premio;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("reporteEstudiante")
public class EstudiantePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Estudiante estudiante =(Estudiante) model.get("estudiante");
		Clase clase = (Clase) model.get("clase");
		
		PdfPTable tabla = new PdfPTable(1);
		tabla.setSpacingAfter(20);
		
		PdfPCell cell = null;
		
		cell = new PdfPCell(new Phrase("Datos del estudiante"));
		cell.setBackgroundColor(new Color(85,159,234));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		cell.setPadding(8f);
		tabla.addCell(cell);
		tabla.addCell("Nombre: "+estudiante.getNombre());
		tabla.addCell("Apellido: "+estudiante.getApellido());
		tabla.addCell("Profesor: "+clase.getProfesor().getNombre()+" "+clase.getProfesor().getApellidos());
		tabla.addCell("Clase: "+clase.getNombre());
		tabla.addCell("Grado: "+clase.getGrado().getNombre());
		
		
		PdfPTable tabla1 = new PdfPTable(1);
		
		cell = new PdfPCell(new Phrase("Acción en clase"));
		cell.setBackgroundColor(new Color(95,245,127));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		cell.setPadding(8f);
		tabla1.addCell(cell);
		
		document.add(tabla);
		document.add(tabla1);
		
		PdfPTable tabla2 = new PdfPTable(3);
		tabla2.setSpacingAfter(20);
		tabla2.addCell("Positivo");
		tabla2.addCell("Negativo");
		tabla2.addCell("Puntos total");
		
		cell = new PdfPCell(new Phrase(estudiante.getPuntosFavor().toString()));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla2.addCell(cell);
		
		cell = new PdfPCell(new Phrase(estudiante.getPuntosContra().toString()));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla2.addCell(cell);
		
		cell = new PdfPCell(new Phrase(estudiante.getPuntosTotal().toString()));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla2.addCell(cell);
		
		PdfPTable tabla3 = new PdfPTable(1);
		cell = new PdfPCell(new Phrase("Lista de premios"));
		cell.setBackgroundColor(new Color(251,255,0));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		cell.setPadding(8f);
		tabla3.addCell(cell);
		
		for(Premio premio: estudiante.getPremioList()){
			cell = new PdfPCell(new Phrase(premio.getNombre_premio()));
			cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			tabla3.addCell(cell);
		}
		
		document.add(tabla2);
		document.add(tabla3);
		
	}

}
