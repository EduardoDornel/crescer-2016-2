﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Projeto2Evento_Dominio
{
    public class Admin
    {
        public Admin()
        {

        }

        public Admin(string email, string senha)
        {
            this.Email = email;
            this.Senha = senha;
        }

        public int Id { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }
        public string Nome { get; set;}
    }
}
