using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Configuration;
using System.Data.SqlClient;
using System.Transactions;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio
    {
        
        public PersonagemRepositorio()
        {

        }

        public List<Personagem> ListarPersonagens(string filtro)
        {
            string connectionString =
       ConfigurationManager.ConnectionStrings["StreetFighterConnection"].ConnectionString;

            List<Personagem> personagens = new List<Personagem>();

            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = $"SELECT * FROM Personagem WHERE Nome LIKE @param_nome";

                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param_nome", $"%{filtro}%"));

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Personagem personagem = ConvertReaderToPersonagem(reader);
                    personagens.Add(personagem);
                }
                connection.Close();
            }
            return personagens;
        }

        public void ModificarPersonagem(Personagem personagem)
        {
            string connectionString =
                ConfigurationManager.ConnectionStrings["StreetFighterConnection"].ConnectionString;

            using (var transaction = new TransactionScope(TransactionScopeOption.Required))
            using (var connection = new SqlConnection(connectionString))
            {
                try
                {
                    connection.Open();

                    string sql = "";
                    var parameters = new List<SqlParameter>();
                    if (personagem.Id > 0)
                    {
                        sql = $"UPDATE Personagem SET Nome=@param_Nome, PrimeiraAparicao=@param_PrimeiraAparicao, DataNascimento=@param_DataNascimento, Altura=@param_Altura, Peso=@param_Peso, Origem=@param_Origem, Imagem=@param_Imagem, GolpesEspeciais=@param_GolpesEspeciais, PersonagemOculto=@param_PersonagemOculto  WHERE Id = @param_Id";

                        parameters.Add(new SqlParameter("param_Nome", personagem.Nome));
                        parameters.Add(new SqlParameter("param_PrimeiraAparicao", personagem.PrimeiraAparicao));
                        parameters.Add(new SqlParameter("param_DataNascimento", personagem.DataNascimento));
                        parameters.Add(new SqlParameter("param_Altura", personagem.Altura));
                        parameters.Add(new SqlParameter("param_peso", personagem.Peso));
                        parameters.Add(new SqlParameter("param_origem", personagem.Origem));
                        parameters.Add(new SqlParameter("param_Imagem", personagem.Imagem));
                        parameters.Add(new SqlParameter("param_GolpesEspeciais", personagem.GolpesEspeciais));
                        parameters.Add(new SqlParameter("param_PersonagemOculto", personagem.PersonagemOculto));
                        parameters.Add(new SqlParameter("param_Id", personagem.Id));
                    }
                    else
                    {
                        sql = $"INSERT INTO Personagem (Nome,PrimeiraAparicao,DataNascimento,Altura,Peso,Origem,Imagem,GolpesEspeciais,PersonagemOculto) VALUES (@param_Nome,@param_PrimeiraAparicao,@param_DataNascimento,@param_Altura,@param_Peso,@param_Origem,@param_Imagem,@param_GolpesEspeciais,@param_PersonagemOculto)";
                        parameters.Add(new SqlParameter("param_nome", personagem.Nome));
                        parameters.Add(new SqlParameter("param_PrimeiraAparicao", personagem.PrimeiraAparicao));
                        parameters.Add(new SqlParameter("param_dataNascimento", personagem.DataNascimento));
                        parameters.Add(new SqlParameter("param_altura", personagem.Altura));
                        parameters.Add(new SqlParameter("param_peso", personagem.Peso));
                        parameters.Add(new SqlParameter("param_origem", personagem.Origem));
                        parameters.Add(new SqlParameter("param_imagem", personagem.Imagem));
                        parameters.Add(new SqlParameter("param_golpesEspeciais", personagem.GolpesEspeciais));
                        parameters.Add(new SqlParameter("param_personagemOculto", personagem.PersonagemOculto));
                    }



                    var command = new SqlCommand(sql, connection);
                    foreach (SqlParameter param in parameters)
                    {
                        command.Parameters.Add(param);
                    }
                    command.ExecuteNonQuery();
                    transaction.Complete();
                }
                catch (Exception)
                {
                    ////////
                }
                finally
                {
                    connection.Close();
                }
            }
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            /////////////////
        }

        private Personagem ConvertReaderToPersonagem(SqlDataReader reader)
        {
            string nome = reader["Nome"].ToString();
            int id = Convert.ToInt32(reader["Id"]);
            string origem = reader["Origem"].ToString();
            string golpesEspeciais = reader["GolpesEspeciais"].ToString();
            DateTime dataNascimento = Convert.ToDateTime(reader["DataNascimento"]);
            string primeiraAparicao = reader["PrimeiraAparicao"].ToString();
            decimal peso = Convert.ToDecimal(reader["Peso"]);
            string imagem = reader["Imagem"].ToString();
            bool personagemOculto = Convert.ToBoolean(reader["PersonagemOculto"]);
            int altura = Convert.ToInt32(reader["Altura"]);

            return new Personagem(nome, origem, id, golpesEspeciais, dataNascimento, primeiraAparicao, peso, imagem, personagemOculto, altura);
        }

    }
}
