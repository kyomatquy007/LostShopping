using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LostShoppingServer.Controllers
{
    public class SubCategoryController : ApiController
    {
        //show all data
        [HttpGet]
        public List<SUBCATEGORY>showAllSubCategory()
        {
            SubCategoryDataContext context = new SubCategoryDataContext();
            return context.SUBCATEGORies.ToList();
        }
        //show subcategory by ID
        [HttpGet]
        public SUBCATEGORY getDataByID(int ID)
        {
            SubCategoryDataContext context = new SubCategoryDataContext();
            SUBCATEGORY subcat = context.SUBCATEGORies.FirstOrDefault(x => x.SUBCAT_ID == ID);
            return subcat;
        }
    }
}
