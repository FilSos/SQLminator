package visitors;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitor;
import net.sf.jsqlparser.statement.Statements;
import net.sf.jsqlparser.statement.alter.Alter;
import net.sf.jsqlparser.statement.create.index.CreateIndex;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.create.view.CreateView;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.drop.Drop;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.replace.Replace;
import net.sf.jsqlparser.statement.select.Join;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.WithItem;
import net.sf.jsqlparser.statement.truncate.Truncate;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.util.ArrayList;
import java.util.List;

public class ColumnNamesFinder extends TablesNamesFinder {

    List<String> tableColumns = new ArrayList<>();

    @Override
    public void visit(Column tableColumn) {
        tableColumns.add(tableColumn.getFullyQualifiedName());
    }

    public List<String> getTableColumns(Statement statement) {
        tableColumns = new ArrayList<>();
        statement.accept(this);
        return tableColumns;
    }

    public List<String> getTableColumns(Delete delete) {
        tableColumns = new ArrayList<>();
        delete.getTable().accept(this);
        delete.getWhere().accept(this);
        return tableColumns;
    }
    public List<String> getTableColumns(Insert insert) {
        tableColumns = new ArrayList<>();
        insert.getTable().accept(this);
        if (insert.getItemsList() != null) {
            insert.getItemsList().accept(this);
        }
        return tableColumns;
    }
    public List<String> getTableColumns(Replace replace) {
        tableColumns = new ArrayList<>();
        if (replace.getExpressions() != null) {
            for (Expression expression : replace.getExpressions()) {
                expression.accept(this);
            }
        }
        if (replace.getItemsList() != null) {
            replace.getItemsList().accept(this);
        }

        return tableColumns;
    }

    public List<String> getTableColumns(Select select) {
        tableColumns = new ArrayList<>();
        if (select.getWithItemsList() != null) {
            for (WithItem withItem : select.getWithItemsList()) {
                withItem.accept(this);
            }
        }
        select.getSelectBody().accept(this);

        return tableColumns;
    }
    public List<String> getTableColumns(Update update) {
        tableColumns = new ArrayList<>();
        update.getTable().accept(this);
        if (update.getExpressions() != null) {
            for (Expression expression : update.getExpressions()) {
                expression.accept(this);
            }
        }

        if (update.getFromItem() != null) {
            update.getFromItem().accept(this);
        }

        if (update.getJoins() != null) {
            for (Join join : update.getJoins()) {
                join.getRightItem().accept(this);
            }
        }

        if (update.getWhere() != null) {
            update.getWhere().accept(this);
        }

        return tableColumns;
    }

    @Override
    public void visit(Table tableName) {
    }
}