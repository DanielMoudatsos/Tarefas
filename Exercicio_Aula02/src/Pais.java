import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pais {
   private int id;
   private String nome;
   private long populacao;
   private double area;
   
   static {
	   try {
	   Class.forName("com.mysql.jdbc.Driver");
	   } catch (ClassNotFoundException e) {
	   throw new RuntimeException(e);
	   }
	   }
   public Pais() {
	   
   }
   public Pais(int id,String nome,long populacao,double area) {
	   this.id = id;
	   this.nome = nome;
	   this.populacao = populacao;
	   this.area = area;
   }
   public Connection obtemConexao() throws SQLException {
	   return DriverManager
	   .getConnection("jdbc:mysql://localhost/exercicio?user=root&password=dewte58000");
	   }
   public void criar() {
	   String sqlInsert = "INSERT INTO Pais(nome) VALUES (?,?,?)";
	   
	   try (Connection conn = obtemConexao();
	          PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
	     stm.setString(1, getNome());
	     stm.setLong(2, getPopulacao());
	     stm.setDouble(3, getArea());
	     stm.execute();
	     String sqlQuery = "SELECT LAST_INSERT_ID()";
	     try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
	         ResultSet rs = stm2.executeQuery();) {
	         if(rs.next()){
	              setId(rs.getInt(1));
	         }
	     } catch (SQLException e) {
	        e.printStackTrace();
	     }
	     
	   } catch (SQLException e) {
	      e.printStackTrace();
	   }
    }
   public void atualizar() {
	   String sqlUpdate = "UPDATE cliente SET nome=?, populacao=?, area=? WHERE id=?";
	   try (Connection conn = obtemConexao();
	         PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
	      stm.setString(1, getNome());
	      stm.setLong(2, getPopulacao());
	      stm.setDouble(3, getArea());
	      stm.setInt(4, getId());
	      stm.execute();
	   } catch (Exception e) {
	       e.printStackTrace();
	   }
   }

   public void excluir() {
	   String sqlDelete = "DELETE FROM cliente WHERE id = ?";
	   try (Connection conn = obtemConexao();
	          PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
	       stm.setInt(1, getId());
	       stm.execute();
	   } catch (Exception e) {
	       e.printStackTrace();
	   }
   }
   
   public void carregar() {
	   String sqlSelect = "SELECT nome, populacao, area FROM cliente WHERE cliente.id = ?";
	   try (Connection conn = obtemConexao();
	         PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
	       stm.setInt(1, getId());
	       try (ResultSet rs = stm.executeQuery();) {
	           if (rs.next()) {
	               setNome(rs.getString("nome"));
	               setPopulacao(rs.getLong("populacao"));
	               setArea(rs.getDouble("area"));
	            } else {
	               setId(-1);
	               setNome(null);
	               setPopulacao(-1);
	               setArea(-1);
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      } catch (SQLException e1) {
	          System.out.print(e1.getStackTrace());
	   }
	   }
  
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public long getPopulacao() {
	return populacao;
}
public void setPopulacao(long populacao) {
	this.populacao = populacao;
}
public double getArea() {
	return area;
}
public void setArea(double area) {
	this.area = area;
}

@Override
public String toString() {
   return "paises [id=" + id + ", nome=" + nome + ", populacao=" + populacao
      + ", area=" + area + "]";
}
@Override
public boolean equals(Object obj) {
   if (this == obj)
      return true;
   if (obj == null)
      return false;
   if (getClass() != obj.getClass())
      return false;
   Pais other = (Pais) obj;
   if (area == -1) {
 	  if (other.area != -1)
 	  return false;
 	  } else if (!(area ==(other.area)))
 	  return false;
 	  if (populacao == -1) {
 	  if (other.populacao != -1)
 	  return false;
 	  } else if (!(populacao == (other.populacao)))
 	  return false;
   if (id != other.id)
      return false;
   if (nome == null) {
      if (other.nome != null)
         return false;
   } else if (!nome.equals(other.nome))
      return false;
   return true;
}
public String  MaiorPopu() {
	String sqlSelect = "select max(pupolacao) from paises";
	try (Connection conn = obtemConexao();
		      PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		         stm.setInt(1, getId());
		         try (ResultSet rs = stm.executeQuery();) {
		            if (rs.next()) {
		               setNome(rs.getString("nome"));
		               setPopulacao(rs.getLong("populacao"));
		               
		            } else {
		               setId(-1);
		               setNome(null);
		               setPopulacao(-1);
		               
		            }
		         } catch (SQLException e) {
		            e.printStackTrace();
		         }
		      } catch (SQLException e1) {
		         System.out.print(e1.getStackTrace());
		      }
	return sqlSelect;
		   }


public String MenorArea() {
	String sqlSelect = "select min() from paises";
	try (Connection conn = obtemConexao();
		      PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		         stm.setInt(1, getId());
		         try (ResultSet rs = stm.executeQuery();) {
		            if (rs.next()) {
		               setNome(rs.getString("nome"));
		               setArea(rs.getDouble("area"));
		               
		            } else {
		               setId(-1);
		               setNome(null);
		               setArea(-1);
		               
		            }
		         } catch (SQLException e) {
		            e.printStackTrace();
		         }
		      } catch (SQLException e1) {
		         System.out.print(e1.getStackTrace());
		      }
	return sqlSelect;
		   }


public String MenorPopu() {
	String sqlSelect = "select min() from paises ";
	try (Connection conn = obtemConexao();
		      PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		         stm.setInt(1, getId());
		         try (ResultSet rs = stm.executeQuery();) {
		            if (rs.next()) {
		               setNome(rs.getString("nome"));
		               setArea(rs.getDouble("area"));
		               
		            } else {
		               setId(-1);
		               setNome(null);
		               setArea(-1);
		               
		            }
		         } catch (SQLException e) {
		            e.printStackTrace();
		         }
		      } catch (SQLException e1) {
		         System.out.print(e1.getStackTrace());
		      }
	return sqlSelect;
		   }
public String VetorTresPaises() {
	String sqlSelect = "select * from paises limit 3";
	try (Connection conn = obtemConexao();
		      PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		         stm.setInt(1, getId());
		         try (ResultSet rs = stm.executeQuery();) {
		        	 if (rs.next()) {
		                 setNome(rs.getString("nome"));
		                 setPopulacao(rs.getLong("populacao"));
		                 setArea(rs.getDouble("area"));
		              } else {
		                 setId(-1);
		                 setNome(null);
		                 setPopulacao(-1);
		                 setArea(-1);
		              }
		         } catch (SQLException e) {
		            e.printStackTrace();
		         }
		      } catch (SQLException e1) {
		         System.out.print(e1.getStackTrace());
		      }
	return sqlSelect;
		   }
}
