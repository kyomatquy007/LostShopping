using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Data.Linq;

namespace LostShoppingServer.Controllers
{
    public class ProductController : ApiController
    {
        //Get all data
        [HttpGet]
        public List<PRODUCT>showAllProduct()
        {
            DataClasses1DataContext context = new DataClasses1DataContext();
            return context.PRODUCTs.ToList();
        }

        //get data by SubCategory ID
        [HttpGet]
        public List<PRODUCT>getDataBySubcatID(int sub_cat_id)
        {
            DataClasses1DataContext context = new DataClasses1DataContext();
            var results = from x in context.PRODUCTs
                            .Where(x => x.PRO_SUBCAT_ID == sub_cat_id)
                            select x;
            return results.ToList();
        }

        //get data by Product ID
        [HttpGet]
        public PRODUCT getProductDetail(int pro_id)
        {
            DataClasses1DataContext context = new DataClasses1DataContext();
            PRODUCT pro = context.PRODUCTs.FirstOrDefault(x => x.PRO_ID == pro_id);
            return pro;
        }
    }
}
