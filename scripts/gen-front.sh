echo "generated frontend module in backend project"
echo "analog of Studio 'create frontend module' command"
echo "shold be run from root directory of backend project"

echo ""
echo "'frontend' folder will be cleaned and re-created"
cd ..
rm -rf frontend
mkdir frontend
cd frontend

echo ""
echo "start generating app"
npx @amplicode/codegen react-typescript:app\
 --schema ../src/main/resources/graphql/schema.graphqls\
 --answers eyJhcHBUaXRsZSI6IkFtcGwgQ3VzdG9tIElkcyIsImFwcFNob3J0TmFtZSI6ImFtcGwtY3VzdGlkcyIsImdyYXBocWxVcmkiOiIvZ3JhcGhxbCIsImJhc2VQYXRoIjoiZnJvbnQifQ==

echo ""
echo "run mpm install"
npm i
