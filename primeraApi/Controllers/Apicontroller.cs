using Microsoft.AspNetCore.Mvc;
using System.Runtime.InteropServices.Marshalling;

namespace primeraApi.Controllers
{
    [ApiController]
    [Route("api/[controller]")]

    public class PruebaController : Controller
    {
        public IActionResult Index()
        {
            string msn = "HOLA MUNDO";
            return Ok(new
            {
                msn
            });
        }



        [HttpGet("iva")]
        public IActionResult CalcIVa(
            [FromQuery] decimal precio
            )
        {
            decimal iva = precio * (decimal)0.15;
            decimal total = iva + precio;
            return Ok(
                new
                {
                    precio,
                    iva,
                    total

                }
                );

        }

        [HttpGet("estudiante")]
        public IActionResult Estudiante(
    [FromQuery] string nombre,
    [FromQuery] string apellido,
    [FromQuery] string carrera,
    [FromQuery] decimal promedio
)
        {
            string nivel;

            if (promedio >= 90)
            {
                nivel = "Aprendizaje satisfactorio";
            }
            else if (promedio >= 80)
            {
                nivel = "Aprendizaje moderado";
            }
            else if (promedio >= 70)
            {
                nivel = "Aprendizaje inicial";
            }
            else
            {
                nivel = "Sos una vaca";
            }

            return Ok(
                new
                {
                    nombre,
                    apellido,
                    carrera,
                    promedio,
                    nivel
                }
            );
        }


    }
}
