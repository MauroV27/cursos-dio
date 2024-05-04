using System;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;

using Microsoft.EntityFrameworkCore;
using TrilhaApiDesafio.Context;

namespace TrilhaApiDesafio
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            // services.AddDomain();
            // services.AddApiData(Configuration);

            #region : Código para criar uma instância de sqlite na mesma pasta do projeto ----------------
            var path = Directory.GetCurrentDirectory();
            string sqlPath = System.IO.Path.Join(path, "Aplication.sqlite");

            Console.WriteLine($"Path for SQLite data : {sqlPath}");

            services.AddDbContext<OrganizadorContext>(options => {
                options.UseSqlite( $"Data Source={sqlPath}"  );
            });
            #endregion -----------------------------------------------------------------------------------

            services.AddControllers();
            services.AddEndpointsApiExplorer();
            services.AddSwaggerGen();
            // services.AddSwaggerDocument();
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
                app.UseSwagger();
                app.UseSwaggerUI();
            }

            app.UseHttpsRedirection();

            app.UseRouting();

            app.UseAuthentication();
            app.UseAuthorization();

            // app.UseOpenApi();
            // app.UseSwaggerUi3();
            
            app.UseEndpoints(endpoints => { endpoints.MapControllers(); });
        }
    }
}