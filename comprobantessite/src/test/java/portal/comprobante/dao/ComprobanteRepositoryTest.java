package portal.comprobante.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import portal.comprobante.dao.interfaces.IComprobanteRepository;
import portal.comprobante.entity.Comprobante;

@ContextConfiguration(locations = "classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ComprobanteRepositoryTest {
	
//	private ApplicationContext context;
	@Autowired
	private IComprobanteRepository comprobanteRepo;
	
//	@Before
//    public void setUp() throws Exception {
//        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
//        usuarioRepo = (UsuarioRepository) context.getBean("usuarioRepository");
//    }
	
	@Test
	public void registrarComprobanteTest() throws Exception
	{
		Comprobante comprobante = new Comprobante();
		comprobante.setRuc("0123456789");
		comprobante.setRucEmisor("01234567891");
		comprobante.setSerieCorrelativo("12345");
		comprobante.setFechaEmision("2017/07/16");
		comprobante.setMonto(300.00);
		comprobante.setTipoDocumento("1");
		comprobante.setXml("xml");
		comprobante.setPdf("pdf");
		
		comprobanteRepo.registrarComprobante(comprobante);
	}
}