
import Model.Pais;
import DAO.PaisDAO;
	public class PaisService {
		static PaisDAO dao = new PaisDAO();
		
		public static int criar(Pais pais) {
			return dao.criar(pais);
		}
		
		public void atualizar(Pais pais){
			dao.atualizar(pais);
		}
		
		public void excluir(int id){
			dao.excluir(id);
		}
		
		public Pais carregar(int id){
			return dao.carregar(id);
		}

	}
