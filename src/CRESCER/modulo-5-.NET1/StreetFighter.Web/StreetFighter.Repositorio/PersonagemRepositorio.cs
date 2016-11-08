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
        //public List<Personagem> Personagens { get; private set; } = new List<Personagem>();
        //public static string CaminhoArquivo = @"~\StreetFighter.Repositorio\ListaPersonagens.csv";

        public PersonagemRepositorio()
        {

        }
       /* public List<Personagem> FileToList()
        {
           // System.IO.StreamReader file = new System.IO.StreamReader(CaminhoArquivo);
            var linhas = File.ReadLines(CaminhoArquivo);

            foreach (var linha in linhas)
            {
                string[] split = linha.Split(';');
                Personagens.Add(new Personagem(
                    split[0],
                    split[1],
                    Int32.Parse(split[2]),
                    split[3],
                    Convert.ToDateTime(split[4]),
                    split[5],
                    System.Convert.ToDecimal(split[6]),
                    split[7],
                    Convert.ToBoolean(split[8]),
                    Int32.Parse(split[9])
                    ));

            }

         //   file.Close();
            return Personagens;
        }*/

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
                    if (personagem.Id <= 0)
                    {
                        sql = $"INSERT into Personagem(@param_Nome, @param_Origem, @param_GolpesEspeciais, @param_DataNascimento, @param_PrimeiraAparicao, " +
                                        $"@param_Peso, @param_Imagem, @param_PersonagemOculto, @param_Altura)" +
                                       $"VALUES({personagem.Nome},{personagem.Origem},{personagem.GolpesEspeciais},{personagem.DataNascimento},{personagem.PrimeiraAparicao},{personagem.Peso},{personagem.Imagem},{personagem.PersonagemOculto},{personagem.Altura} )";
                        parameters.Add(new SqlParameter("param_Nome", personagem.Nome));
                        parameters.Add(new SqlParameter("param_Origem", personagem.Origem));
                        parameters.Add(new SqlParameter("param_GolpesEspeciais", personagem.GolpesEspeciais));
                        parameters.Add(new SqlParameter("param_DataNascimento", personagem.DataNascimento));
                        parameters.Add(new SqlParameter("param_PrimeiraAparicao", personagem.PrimeiraAparicao));
                        parameters.Add(new SqlParameter("param_Peso", personagem.Peso));
                        parameters.Add(new SqlParameter("param_Imagem", personagem.Imagem));
                        parameters.Add(new SqlParameter("param_PersonagemOculto", personagem.PersonagemOculto));
                        parameters.Add(new SqlParameter("param_Altura", personagem.Altura));
                    }
                    else
                    {
                        sql = $"UPDATE Personagem SET Nome=@param_Nome, Origem=@param_Origem, GolpesEspeciais=@param_GolpesEspeciais, DataNascimento=@param_DataNascimento, PrimeiraAparicao=@param_PrimeiraAparicao, Peso=@param_Peso, Imagem=@param_Imagem, PersonagemOculto=@param_PersonagemOculto, Altura=@param_Altura WHERE Id = @param.Id";
                        parameters.Add(new SqlParameter("param_Nome", personagem.Nome));
                        parameters.Add(new SqlParameter("param_Origem", personagem.Origem));
                        parameters.Add(new SqlParameter("param_GolpesEspeciais", personagem.GolpesEspeciais));
                        parameters.Add(new SqlParameter("param_DataNascimento", personagem.DataNascimento));
                        parameters.Add(new SqlParameter("param_PrimeiraAparicao", personagem.PrimeiraAparicao));
                        parameters.Add(new SqlParameter("param_Peso", personagem.Peso));
                        parameters.Add(new SqlParameter("param_Imagem", personagem.Imagem));
                        parameters.Add(new SqlParameter("param_PersonagemOculto", personagem.PersonagemOculto));
                        parameters.Add(new SqlParameter("param_Altura", personagem.Altura));
                    }


                    var command = new SqlCommand(sql, connection);
                    foreach (SqlParameter param in parameters)
                    {
                        command.Parameters.Add(param);
                    }
                    command.ExecuteNonQuery();
                    transaction.Complete();
                }
                catch (Exception ex)
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
